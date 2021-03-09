package com.example.venturustest.domain

import com.example.venturustest.domain.models.ResponseGallery
import retrofit2.Call

class Repository(private val service: GalleryService) {

    fun getGallery(): Call<ResponseGallery> {
        return service.getGallery("Client-ID 0d1af9d70613bc4","top","week")
    }

}