package com.example.tapasoft.testusersapp.api

import com.example.tapasoft.testusersapp.model.PersonPage
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/?results=20&exc=login,registered")
    fun getUserPageAsync(): Deferred<Response<PersonPage>>
}