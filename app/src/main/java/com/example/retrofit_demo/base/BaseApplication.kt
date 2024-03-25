package com.example.retrofit_demo.base

import android.app.Application
import android.content.Context

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MyAppContext.context =this
    }
}

