package com.neverova.project

import android.app.Application
import com.neverova.project.di.AppComponent
import com.neverova.project.di.DaggerAppComponent
import com.neverova.project.di.modules.DatabaseModule
import com.neverova.project.di.modules.DomainModule
import com.neverova.project.di.modules.RemoteModule

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}


