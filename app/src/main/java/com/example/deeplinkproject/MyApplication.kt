package com.example.deeplinkproject

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi

const val CHANNEL_ID = "demoChannel"

class MyApplication: Application() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        val notificationManager = getSystemService(NOTIFICATION_SERVICE)as NotificationManager

        val channel = NotificationChannel(CHANNEL_ID, "name", NotificationManager.IMPORTANCE_DEFAULT)

        notificationManager.createNotificationChannel(channel)


    }
}