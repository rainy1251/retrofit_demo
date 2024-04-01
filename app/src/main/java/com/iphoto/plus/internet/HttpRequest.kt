package com.iphoto.plus.internet

import com.iphoto.plus.utils.DialogManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object HttpRequest {
    fun execute(http: HttpPredicate) = CoroutineUtil.execMain {
        val showRound = DialogManager.showRound()
        try {
            http.execute(RetrofitClient.apiService)
        } catch (e: Exception) {
            throw e
        } finally {
            showRound?.let {
                if (it.isShowing) {
                    it.cancel()
                }
            }
        }
    }


    fun executeAsync(http: HttpPredicate) =
        CoroutineScope(Dispatchers.Main).launch(CoroutineHandler) {
            http.execute(RetrofitClient.apiService)
        }
}