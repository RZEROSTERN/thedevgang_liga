package com.thedevgang.liga.presentation.ui.upcoming

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation

import com.thedevgang.liga.R

class UpcomingFragment : Fragment() {

    companion object {
        fun newInstance() = UpcomingFragment()
    }

    private lateinit var viewModel: UpcomingViewModel
    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.upcoming_fragment, container, false)

        var activity = requireActivity() as AppCompatActivity
        toolbar = view.findViewById(R.id.tb_upcoming)
        toolbar!!.setTitleTextColor(resources.getColor(android.R.color.white))
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar!!.title = "Upcoming"
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UpcomingViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_upcomingFragment_to_dashboardFragment)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
