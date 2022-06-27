package com.okankkl.apitest.Service

import com.okankkl.apitest.Response.ApiResponse
import com.okankkl.apitest.repository.ApiRepository
import retrofit2.Call
import retrofit2.http.GET

interface ApiDAOInterface {

    @GET("entries")
    fun getAllApis() : Call<ApiResponse>

}