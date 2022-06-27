package com.okankkl.apitest.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.okankkl.apitest.Model.API

data class ApiResponse(

    @SerializedName("entries")
    @Expose var entries: List<API>,
    @SerializedName("count")
    @Expose var count : Int


    )