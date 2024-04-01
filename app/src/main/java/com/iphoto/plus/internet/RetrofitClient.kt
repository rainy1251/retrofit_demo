package com.iphoto.plus.internet


import android.util.Log
import com.iphoto.plus.utils.SpUtil
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val Authorization = "Auth"
    private const val UserAgent = "User-Agent"

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .addInterceptor { chain: Interceptor.Chain ->
            // 这里配置了统一拦截器用以添加token 如果不需要可以去掉
            val request = chain.request().newBuilder().apply {
                addHeader(UserAgent, "Android")
                SpUtil.decodeString("token")?.let {
                    addHeader(Authorization, it)
                }
            }.build()
            Log.d("Request","request: ${request.method()} ${request.url()} ${request.body().toString()}\n${request.headers()}")
            chain.proceed(request)
        }
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://javaclassapi.rb.ejiang.com:9151")
        .addConverterFactory(GsonResponseConverterFactory)
        .client(okHttpClient)
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}