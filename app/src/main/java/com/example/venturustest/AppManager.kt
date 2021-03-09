package com.example.venturustest

import com.example.venturustest.data.UseCase
import com.example.venturustest.networkUtils.ApiClient
import com.example.venturustest.domain.Repository
import com.example.venturustest.domain.GalleryService
import com.example.venturustest.presentation.HomeViewModel

object AppManager {

    private fun createRepository() : Repository {
        return Repository(ApiClient.instance.getService(GalleryService::class.java))
    }

    private fun createUseCase() : UseCase {
        return UseCase(createRepository())
    }

    fun createViewModel(): HomeViewModel {
        return HomeViewModel(createUseCase())
    }

}