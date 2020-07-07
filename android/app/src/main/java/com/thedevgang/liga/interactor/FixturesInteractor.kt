package com.thedevgang.liga.interactor

import com.thedevgang.liga.data.dao.results.FixtureResult
import io.reactivex.Observable

interface FixturesInteractor {
    fun getFixturesByDate(date: String): Observable<FixtureResult>
}