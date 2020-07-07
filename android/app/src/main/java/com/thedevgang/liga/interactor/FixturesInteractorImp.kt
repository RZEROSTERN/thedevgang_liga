package com.thedevgang.liga.interactor

import android.util.Log
import com.thedevgang.liga.data.dao.results.FixtureResult
import com.thedevgang.liga.repository.FixturesRepositoryImp
import io.reactivex.Observable

class FixturesInteractorImp(private val fixturesRepositoryImp: FixturesRepositoryImp): FixturesInteractor {
    private val TAG = FixturesInteractorImp::class.java.simpleName

    override fun getFixturesByDate(date: String): Observable<FixtureResult> {
        return fixturesRepositoryImp.getFixturesByDate(date)
            .doOnNext { response -> Log.d(TAG, response.toString()) }
            .doOnComplete {Log.d(TAG, "Service complete")}
            .onErrorReturn { error ->
                Log.e(TAG, error.message!!)
                null
            }
    }
}