package com.neverova.project

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.neverova.project.di.AppComponent
import com.neverova.project.di.DaggerAppComponent
import com.neverova.project.di.modules.DatabaseModule
import com.neverova.project.di.modules.DomainModule
import com.neverova.project.di.modules.RemoteModule
import com.example.remote_module.DaggerRemoteComponent

class App : Application() {
    lateinit var dagger: AppComponent
    var isPromoShown = false

    override fun onCreate() {
        super.onCreate()
        instance = this
        val remoteProvider = DaggerRemoteComponent.create()
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "WatchLaterChannel"
            val descriptionText = "FilmsSearch notification Channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            mChannel.description = descriptionText
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }


    companion object {
        lateinit var instance: App
            private set
    }
}


