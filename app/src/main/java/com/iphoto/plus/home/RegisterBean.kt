package com.iphoto.plus.home

data class RegisterBean(
    val phone: String,
    val password: String,
    val username: String,
    val verifyCode: String
)