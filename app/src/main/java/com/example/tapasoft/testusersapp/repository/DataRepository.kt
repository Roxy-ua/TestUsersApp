package com.example.tapasoft.testusersapp.repository

import com.example.tapasoft.testusersapp.model.PersonPage

abstract class DataRepository : BaseRepository() {
    abstract suspend fun getUsers(): PersonPage?
}