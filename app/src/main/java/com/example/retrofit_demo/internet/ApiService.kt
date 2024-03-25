package com.example.retrofit_demo.internet

import com.example.retrofit_demo.home.BannerBean
import com.example.retrofit_demo.home.LocationBean
import com.example.retrofit_demo.home.ResponseBean
import com.example.retrofit_demo.home.TeacherWeekBean
import com.example.retrofit_demo.home.User
import retrofit2.Call

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {
    // 直接使用的网上接口，用作测试
    @GET("/javaApi/homePage/getServerTime")
    suspend fun test(): Response<User>

    @GET("/location")
    suspend fun location(): Response<LocationBean>
   // ?limit=10&offset=0
    @GET("/appletbanner")
    suspend fun banner(@Query("limit") limit:Int, @Query("offset")offset:Int): Response<BannerBean>

    @POST("/javaApi/teachResearchPlan/addTeachWeek")
    suspend fun postData(@Body requestModel: TeacherWeekBean?): Call<ResponseBean?>?
}