package com.example.venturustest.networkUtils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient private constructor() {

    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private object HOLDER {
        val INSTANCE = ApiClient()
    }

    fun <T: Services> getService(serviceClass: Class<T>): T  {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(serviceClass)
    }

    companion object {
        private const val BASE_URL = "https://api.imgur.com/3/"
        val instance: ApiClient by lazy { HOLDER.INSTANCE }
    }

}