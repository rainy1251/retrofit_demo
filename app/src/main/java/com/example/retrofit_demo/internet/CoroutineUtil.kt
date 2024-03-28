package com.example.retrofit_demo.internet

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object CoroutineUtil {

    fun interface CoroutinePredicate {
        suspend fun execute()
    }

    fun execMain(code: CoroutinePredicate) = CoroutineScope(Dispatchers.Main).launch(CoroutineHandler) {
        code.execute()
    }

    fun execIO(code: CoroutinePredicate) = CoroutineScope(Dispatchers.IO).launch(CoroutineHandler) {
        code.execute()
    }
}