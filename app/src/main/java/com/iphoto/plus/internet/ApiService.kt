package com.iphoto.plus.internet

import com.iphoto.plus.home.LoginBean
import com.iphoto.plus.home.LoginResponseBean
import com.iphoto.plus.home.PhoneBean
import com.iphoto.plus.home.RegisterBean
import com.iphoto.plus.home.ResponseBean
import com.iphoto.plus.home.UserBean
import com.iphoto.plus.home.WeekPlanListBean
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {
    /**
     * 发送验证码
     */
    @POST("/api/v1/aliyun/sendVerifyCode")
    suspend fun sendCode(@Body phoneBean: PhoneBean): Response<ResponseBean>

    /**
     * 注册
     */
    @POST("/api/v1/auth/register")
    suspend fun register(@Body registerBean: RegisterBean): Response<ResponseBean>
    /**
     * 登录
     */
    @POST("/api/v1/auth/login")
    suspend fun login(@Body loginBean: LoginBean): Response<LoginResponseBean>

    @GET("/javaApi/weekPlan/getWeekPlanListForSelect")
    suspend fun getWeekPlanList(@Query ("gradeId")gradeId:String): Response<WeekPlanListBean>

    @GET("/api/v1/user/info")
    suspend fun getUserInfo(): Response<UserBean>
}