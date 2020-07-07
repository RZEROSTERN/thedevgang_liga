package com.thedevgang.liga.data.network

import com.thedevgang.liga.data.dao.results.FixtureResult
import io.reactivex.Observable
import retrofit2.http.GET

import retrofit2.http.Headers
import retrofit2.http.Path

interface RestApi {
    @GET("fixtures/date/{date}")
    @Headers("x-rapidapi-key:5893b857edmshc072b010d35fb24p19d8a0jsn805217687399")
    fun getFixturesByDate(@Path("date") date: String): Observable<FixtureResult>
}