package com.okankkl.apitest.repository

import androidx.lifecycle.MutableLiveData
import com.okankkl.apitest.Model.API
import com.okankkl.apitest.Response.ApiResponse
import com.okankkl.apitest.Service.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository {

    val apiList  = MutableLiveData<List<API>>()

    init {
        getApis()
    }

    fun getApis(){

        ApiUtils.getApiDAOInterface().getAllApis().enqueue(
            object : Callback<ApiResponse> {
                override fun onResponse(
                    call: Call<ApiResponse>,
                    response: Response<ApiResponse>
                ) {
                    try {
                        response.body()?.let {
                            val tempList = it.entries
                            apiList.value = tempList
                        }

                    }
                    catch (exception : Exception){
                        println(exception)
                    }


                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {}

            }
        )
    }

    fun apisGet() : MutableLiveData<List<API>>{
        return apiList
    }

}




