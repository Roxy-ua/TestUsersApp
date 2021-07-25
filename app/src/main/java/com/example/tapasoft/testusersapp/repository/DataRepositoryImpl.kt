package com.example.tapasoft.testusersapp.repository

import com.example.tapasoft.testusersapp.api.ApiInterface
import com.example.tapasoft.testusersapp.model.PersonPage
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(private val api: ApiInterface) : DataRepository() {

    override suspend fun getUsers(): PersonPage? {
        return safeApiCall(
            call = { api.getUserPageAsync().await() },
            errorMessage = "Error Fetching PersonPage"
        )
    }
}