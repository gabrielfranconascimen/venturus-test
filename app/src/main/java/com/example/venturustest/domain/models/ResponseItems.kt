package com.example.venturustest.domain.models

data class ResponseItems(
    val views: Int,
    val ups: Int,
    val downs: Int,
    val comment_count: Int,
    val images: List<ResponseImage>
)