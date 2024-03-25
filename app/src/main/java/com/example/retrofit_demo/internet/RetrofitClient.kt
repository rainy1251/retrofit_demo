package com.example.retrofit_demo.internet


import android.util.Log
import com.example.retrofit_demo.utils.PreferenceManager
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
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
                PreferenceManager.getToken()?.let {
                    addHeader(Authorization, it)
                }
            }.build()
//            Log.d("levi","request: ${request.method()} ${request.url()} ${request.body().toString()}\n" +
//                    "headers: ${request.headers()}")
            chain.proceed(request)
        }
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://javaclassapi.rb.ejiang.com:9151/")
        // 放入之前写好的数据转换工厂
        .addConverterFactory(GsonResponseConverterFactory)
        .client(okHttpClient)
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}