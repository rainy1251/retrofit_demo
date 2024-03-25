package com.example.retrofit_demo.internet

data class Response<T> (
    val code: Int,
    val message: String,
    val data: T
)