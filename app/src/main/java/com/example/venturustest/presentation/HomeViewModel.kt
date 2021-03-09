package com.example.venturustest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.venturustest.data.GalleryItem
import com.example.venturustest.data.UseCase

class HomeViewModel(private val useCase: UseCase) {

    private val showLoadingMLD = MutableLiveData<Boolean>()
    private val showErrorMLD = MutableLiveData<Boolean>()
    private val itemsGalleryMLD = MutableLiveData<List<GalleryItem>>()

    val showLoadingLiveData: LiveData<Boolean> = showLoadingMLD
    val showErrorLiveData: LiveData<Boolean> = showErrorMLD
    val itemsGalleryLiveData: LiveData<List<GalleryItem>> = itemsGalleryMLD

    fun getGallery() {
        showLoadingMLD.value = true
        showErrorMLD.value = false
        useCase.getGallery(success = {
            showLoadingMLD.value = false
            itemsGalleryMLD.value = it
        }, failure = {
            showLoadingMLD.value = false
            showErrorMLD.value = true
        })
    }

}