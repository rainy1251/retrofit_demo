package com.example.retrofit_demo.utils

import android.content.Context
import android.widget.Toast
import com.example.retrofit_demo.base.MyAppContext

object ToastUtil {
    private var toast: Toast? = null

    fun show( content: String) {
        if (toast == null) {
            toast = Toast.makeText(MyAppContext.context, content, Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(content)
        }
        toast!!.show()
    }
}
