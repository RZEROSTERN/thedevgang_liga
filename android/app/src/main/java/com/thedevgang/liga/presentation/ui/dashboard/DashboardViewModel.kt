package com.thedevgang.liga.presentation.ui.dashboard

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thedevgang.liga.data.dao.Fixture
import com.thedevgang.liga.data.dao.Match
import com.thedevgang.liga.interactor.FixturesInteractorImp
import com.thedevgang.liga.repository.FixturesRepositoryImp
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DashboardViewModel : ViewModel() {
    private val fixturesInteractorImp = FixturesInteractorImp(FixturesRepositoryImp())
    private val compositeDisposable = CompositeDisposable()
    private val TAG = DashboardViewModel::class.java.simpleName

    var fixtures: MutableLiveData<MutableList<Fixture>> = MutableLiveData()

    fun retrieveFixtures(date: String) {
        compositeDisposable.add(
            fixturesInteractorImp.getFixturesByDate(date)
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {res -> fixtures.postValue(res.fixtureData.fixtures)},
                    {t: Throwable? -> Log.e(TAG, t!!.message)}
                )
        )
    }
}
