package com.furkan.beinConnectMovies.app

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {
        lateinit var instance: App

        fun getContext(): Context {
            return instance.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}