package com.example.tapasoft.testusersapp.di

import com.example.tapasoft.testusersapp.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)
}