package com.iphoto.plus.internet

fun interface HttpPredicate {
    suspend fun execute(api: ApiService)
}