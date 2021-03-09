package com.example.venturustest.data

import com.example.venturustest.domain.Repository
import com.example.venturustest.domain.models.ResponseGallery
import com.example.venturustest.domain.models.ResponseItems
import com.example.venturustest.extensions.formatter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UseCase(private val repository: Repository) {

    fun getGallery(success: (List<GalleryItem>) -> Unit, failure: () -> Unit ) {
        repository.getGallery().enqueue(object: Callback<ResponseGallery> {

            override fun onResponse(
                call: Call<ResponseGallery>,
                response: Response<ResponseGallery>
            ) {
                val responseGallery = response.body()
                if (responseGallery != null) {
                    success(configGalleryItem(responseGallery.data))
                } else {
                    failure()
                }
            }

            override fun onFailure(call: Call<ResponseGallery>, t: Throwable) {
                failure()
            }
        } )
    }

    private fun configGalleryItem(response: List<ResponseItems>): List<GalleryItem> {
        return response.map { responseItem ->
            val image = responseItem.images

            val points = responseItem.ups - responseItem.downs

            val views = responseItem.views.formatter()

            if (image != null && image.first().type == VALIDATE_IMAGE) {
                GalleryItem(
                    points = points.formatter(),
                    qtdComments = responseItem.comment_count.toString(),
                    views = views,
                    urlImage = image.first().link )
            } else {
                GalleryItem(
                    points = points.formatter(),
                    qtdComments = responseItem.comment_count.toString(),
                    views = views,
                    urlImage = null )
            }
        }.filter {
            it.urlImage != null
        }
    }

    companion object {
        private const val VALIDATE_IMAGE = "image/jpeg"
    }
}