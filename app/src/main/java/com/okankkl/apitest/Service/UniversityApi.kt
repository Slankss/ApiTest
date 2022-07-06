package com.okankkl.apitest.Service


import com.okankkl.apitest.Model.University
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface UniversityApi {

    @GET("search?country=Turkey")
    suspend fun getData() : Response<List<University>>
}