package com.okankkl.apitest.Service

class ApiUtils {

    companion object {

        private const val BASE_URL = "https://api.publicapis.org/"

        fun getApiDAOInterface() : ApiDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(ApiDAOInterface::class.java)
        }
    }

}