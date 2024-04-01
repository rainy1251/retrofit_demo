package com.iphoto.plus.home

data class LoginBean(
    val appId: String,
    val deviceId: String,
    val deviceName: String,
    val ipAddress: String,
    val osName: String,
    val password: String,
    val userName: String,
    val versionName: String
)