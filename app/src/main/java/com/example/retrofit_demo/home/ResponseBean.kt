package com.example.retrofit_demo.home

data class ResponseBean(
    val  code :Int,
    val  message :String ,
    val data : Data
)

data class Data(
   val string: String
)
