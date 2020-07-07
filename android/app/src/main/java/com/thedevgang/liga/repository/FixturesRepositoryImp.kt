package com.thedevgang.liga.repository

import com.thedevgang.liga.data.dao.results.FixtureResult
import com.thedevgang.liga.data.network.RestApi
import com.thedevgang.liga.data.network.RestApiImp
import io.reactivex.Observable

class FixturesRepositoryImp: FixturesRepository {
    private var apiRequest: RestApi = RestApiImp.getClient().create(RestApi::class.java)

    override fun getFixturesByDate(date: String): Observable<FixtureResult> {
        return apiRequest.getFixturesByDate(date)
    }
}