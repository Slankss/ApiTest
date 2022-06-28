package com.okankkl.apitest.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class University (

    @SerializedName("name")
    var name : String,
    @SerializedName("domains") @Expose var domains : ArrayList<String>,

)