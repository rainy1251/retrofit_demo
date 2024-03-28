package com.example.retrofit_demo.utils

import android.widget.Toast

object ToastUtil {
    private var toast: Toast? = null

    fun show( content: String) {
        if (toast == null) {
            toast = Toast.makeText(ActivityManager.getCurrentActivity(), content, Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(content)
        }
        toast!!.show()
    }
}
