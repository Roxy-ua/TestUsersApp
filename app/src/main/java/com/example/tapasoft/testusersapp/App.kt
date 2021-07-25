package com.example.tapasoft.testusersapp

import android.app.Application
import android.content.Context
import com.example.tapasoft.testusersapp.di.AppComponent
import com.example.tapasoft.testusersapp.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

val Context.appComp: AppComponent
    get() = (applicationContext as App).appComponent