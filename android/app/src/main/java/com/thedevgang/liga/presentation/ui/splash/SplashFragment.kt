package com.thedevgang.liga.presentation.ui.splash

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.thedevgang.liga.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashFragment : Fragment() {

    companion object {
        fun newInstance() =
            SplashFragment()
    }

    private lateinit var viewModel: SplashViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.splash_fragment, container, false)

        navController = Navigation.findNavController(requireActivity(), R.id.mainNavHostFragment)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)

        val observer: Observer<Any?> = object : Observer<Any?>{
            override fun onComplete() {
                navController.navigate(R.id.action_splashFragment_to_dashboardFragment)
            }

            override fun onSubscribe(d: Disposable) {}
            override fun onNext(t: Any) {}
            override fun onError(e: Throwable) {}
        }

        Observable.timer(3, TimeUnit.SECONDS, Schedulers.io()).subscribe(observer)
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
