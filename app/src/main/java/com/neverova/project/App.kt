package com.neverova.project

import android.app.Application
import com.neverova.project.di.AppComponent
import com.neverova.project.di.DaggerAppComponent

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}