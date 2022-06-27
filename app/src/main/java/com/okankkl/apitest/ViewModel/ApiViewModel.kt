package com.okankkl.apitest.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.okankkl.apitest.Model.API
import com.okankkl.apitest.Response.ApiResponse
import com.okankkl.apitest.repository.ApiRepository

class ApiViewModel : ViewModel() {

    private val apiRepo = ApiRepository()

    var apiList = MutableLiveData<List<API>>()

    init {
        getKitaplar()
        apiList = apiRepo.apisGet()
    }

    private fun getKitaplar() {
        apiRepo.getApis()
    }

}