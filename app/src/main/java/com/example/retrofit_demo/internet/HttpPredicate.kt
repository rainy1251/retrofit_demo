package com.example.retrofit_demo.internet

fun interface HttpPredicate {
    suspend fun execute(api: ApiService)
}