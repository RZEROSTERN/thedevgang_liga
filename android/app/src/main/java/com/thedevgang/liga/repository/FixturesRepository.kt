package com.thedevgang.liga.repository

import com.thedevgang.liga.data.dao.results.FixtureResult
import io.reactivex.Observable

interface FixturesRepository {
    fun getFixturesByDate(date: String): Observable<FixtureResult>
}