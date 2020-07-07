package com.thedevgang.liga.presentation.ui.dashboard

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getColor
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.thedevgang.liga.R
import com.thedevgang.liga.data.dao.Fixture
import com.thedevgang.liga.data.dao.Match
import com.thedevgang.liga.presentation.ui.dashboard.adapters.MatchesAdapter
import org.jetbrains.anko.support.v4.toast

class DashboardFragment : Fragment() {

    private val TAG = DashboardFragment::class.java.simpleName

    private lateinit var viewModel: DashboardViewModel
    private var toolbar: Toolbar? = null
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

        val callback: OnBackPressedCallback = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                // Do nothing
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.dashboard_fragment, container, false)

        var activity = requireActivity() as AppCompatActivity
        toolbar = view.findViewById(R.id.tb_dashboard)
        toolbar!!.setTitleTextColor(resources.getColor(android.R.color.white))
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar!!.title = "Dashboard"
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        viewModel.fixtures.observe(viewLifecycleOwner, Observer {
            initRecyclerView(it)
        })

        viewModel.retrieveFixtures("2020-07-06")

        initDrawerLayout(savedInstanceState)
    }

    private fun initRecyclerView(matches: MutableList<Fixture>) {
        val matchesAdapter = MatchesAdapter(matches, requireContext())
        recyclerView = requireView().findViewById(R.id.rv_dashboard)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = matchesAdapter
    }

    private fun initDrawerLayout(savedInstanceState: Bundle?) {
        drawerLayout = requireView().findViewById(R.id.dl_dashboard)
        var drawerToggle = setupDrawerToggle()

        drawerToggle!!.isDrawerIndicatorEnabled = true
        drawerToggle!!.syncState()

        drawerLayout.addDrawerListener(drawerToggle!!)

        navigationView = requireView().findViewById(R.id.nvView)

        navigationView.setNavigationItemSelectedListener { item ->
            selectDrawerItem(item)
            true
        }

    }

    private fun selectDrawerItem(item: MenuItem) {
        when(item.itemId) {
            R.id.nav_players -> {
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_dashboardFragment_to_playersFragment)
            }

            R.id.nav_teams -> {
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_dashboardFragment_to_teamsFragment)
            }

            R.id.nav_messages -> {
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_dashboardFragment_to_messagesFragment)
            }

            R.id.nav_upcoming -> {
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_dashboardFragment_to_upcomingFragment)
            }

            R.id.nav_live_matches -> {
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_dashboardFragment_to_liveMatchesFragment)
            }
        }
    }

    private fun setupDrawerToggle(): ActionBarDrawerToggle? {
        return ActionBarDrawerToggle(
            requireActivity(),
            drawerLayout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
