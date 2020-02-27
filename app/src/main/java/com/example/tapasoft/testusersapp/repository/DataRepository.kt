package com.example.tapasoft.testusersapp.repository

import com.example.tapasoft.testusersapp.model.PersonPage


class DataRepository() : BaseRepository() {

    suspend fun getUsers(): PersonPage? {
        return safeApiCall(
            call = { api.getUserPageAsync().await() },
            errorMessage = "Error Fetching PersonPage"
        )
    }
}