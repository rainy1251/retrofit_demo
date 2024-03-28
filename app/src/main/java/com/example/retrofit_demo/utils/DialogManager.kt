package com.example.retrofit_demo.utils


import android.app.AlertDialog
import android.view.View
import android.widget.LinearLayout
import com.example.retrofit_demo.R

object DialogManager {

    fun showRound(): AlertDialog? = ActivityManager.getCurrentActivity()?.let {
        AlertDialog.Builder(it).create().apply {
            window?.run {
                // 设置背景透明,去四个角
                setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                // 设置固定宽带，高度自适应
                setBackgroundDrawableResource(R.color.color_transparent)
            }
            // 设置点击dialog的外部能否取消弹窗
            setCanceledOnTouchOutside(false)
            // 设置能不能返回键取消弹窗
            setCancelable(false)
            show()
            setContentView(
                View.inflate(it, R.layout.alert_dialog_round, null).apply {
                    // 设置成顶层视图
                    bringToFront()
                }
            )
        }
    }
}