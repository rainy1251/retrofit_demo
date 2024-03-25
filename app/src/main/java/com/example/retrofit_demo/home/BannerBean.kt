package com.example.retrofit_demo.home

data class BannerBean(
    val result: List<Result>,
    val total: Int
)

data class Result(
    val contentId: String,
    val contentType: String,
    val id: String,
    val imageUrl: String,
    val sortId: Int,
    val title: String
)