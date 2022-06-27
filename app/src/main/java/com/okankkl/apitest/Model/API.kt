package com.okankkl.apitest.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class API (

    @SerializedName("API") @Expose var apiName: String,
    @SerializedName("Description") @Expose var apiDescription: String,
    @SerializedName("Link") @Expose var apiLink: String,
    @SerializedName("Category") @Expose var apiCategory: String)

    : Serializable
