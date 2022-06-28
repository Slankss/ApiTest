package com.okankkl.apitest.Service


import com.okankkl.apitest.Model.University
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface UniversityApi {

    @GET("search?country=Turkey")
    fun getData() : Call<List<University>>
}