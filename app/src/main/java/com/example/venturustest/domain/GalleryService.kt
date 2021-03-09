package com.example.venturustest.domain

import com.example.venturustest.domain.models.ResponseGallery
import com.example.venturustest.networkUtils.Services
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GalleryService: Services {
    @GET("gallery/{section}/{period}/1")
    fun getGallery(@Header("Authorization") authorization: String,
                   @Path("section") section: String,
                   @Path("period")period: String): Call<ResponseGallery>
}