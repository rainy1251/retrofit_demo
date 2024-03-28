package com.example.retrofit_demo.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.retrofit_demo.utils.ActivityManager
import com.tencent.mmkv.MMKV

class BaseApplication : Application() {
    companion object {
        fun getInstance(): BaseApplication = Inner.instance
    }

    private object Inner {
        lateinit var instance: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        Inner.instance = this
        MyAppContext.context = this
        MMKV.initialize(this)
        // 监听所有Activity的生命周期回调
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
                // 在此处设置当前的Activity
                ActivityManager.setCurrentActivity(activity)
            }

            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityDestroyed(activity: Activity) {
            }
        })

    }
}

