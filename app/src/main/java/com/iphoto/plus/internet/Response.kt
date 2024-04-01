package com.iphoto.plus.internet

data class Response<T> (
    val code: Int,
    val message: String,
    val data: T
)