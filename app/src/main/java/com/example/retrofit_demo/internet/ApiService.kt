package com.example.retrofit_demo.internet

import com.example.retrofit_demo.home.BannerBean
import com.example.retrofit_demo.home.LoginBean
import com.example.retrofit_demo.home.LoginResponseBean
import com.example.retrofit_demo.home.User
import com.example.retrofit_demo.home.WeekPlanListBean

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {
    // 直接使用的网上接口，用作测试
    @GET("javaApi/homePage/getServerTime")
    suspend fun test(): Response<User>

    @GET("/javaApi/weekPlan/getWeekPlanListForSelect")
    suspend fun getWeekPlanList(@Query ("gradeId")gradeId:String): Response<WeekPlanListBean>

   // ?limit=10&offset=0
    @GET("appletbanner")
    suspend fun banner(@Query("limit") limit:Int, @Query("offset")offset:Int): Response<BannerBean>

    @POST("/javaApi/login/validLogin")
    suspend fun login(@Body loginBean: LoginBean): Response<LoginResponseBean>
}