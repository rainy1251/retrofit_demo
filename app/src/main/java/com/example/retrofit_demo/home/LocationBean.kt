package com.example.retrofit_demo.home

data class LocationBean(
    val alpha2: String,
    val alpha3: String,
    val id: Int,
    val local: String,
    val province: List<Province>
)

data class Province(
    val city: List<City>,
    val id: Int,
    val local: String
)

data class City(
    val id: Int,
    val local: String
)