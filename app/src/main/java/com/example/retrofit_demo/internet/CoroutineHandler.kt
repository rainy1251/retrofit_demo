package com.example.retrofit_demo.internet

import android.util.Log
import com.example.retrofit_demo.utils.ToastUtil
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.cancel
import retrofit2.HttpException
import java.net.ConnectException
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

object CoroutineHandler: AbstractCoroutineContextElement(CoroutineExceptionHandler),
    CoroutineExceptionHandler {

    override fun handleException(context: CoroutineContext, exception: Throwable) {
      //  Log.d("Levi",exception.message.toString())
        // 处理
        when(exception.javaClass.name) {
            ConnectException::class.java.name -> ToastUtil.show("请求异常，请检查网络")
            RequestException::class.java.name -> {
                // 处理服务器错误

                val httpResult = JsonUtil.json2Object(exception.message.toString(), Response::class.java)
                Log.d("Levi",httpResult.message)
            }
            HttpException::class.java.name ->{

                when(exception.message.toString()){

                }
            }

        }
        context.cancel()
    }
}