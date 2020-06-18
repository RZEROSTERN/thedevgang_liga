package com.thedevgang.liga.presentation.ui.livematches

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.thedevgang.liga.R

class LiveMatchesFragment : Fragment() {

    companion object {
        fun newInstance() = LiveMatchesFragment()
    }

    private lateinit var viewModel: LiveMatchesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.live_matches_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LiveMatchesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
