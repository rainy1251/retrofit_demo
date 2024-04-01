package com.iphoto.plus.internet

import com.iphoto.plus.home.BannerBean
import com.iphoto.plus.home.LoginBean
import com.iphoto.plus.home.LoginResponseBean
import com.iphoto.plus.home.User
import com.iphoto.plus.home.WeekPlanListBean

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