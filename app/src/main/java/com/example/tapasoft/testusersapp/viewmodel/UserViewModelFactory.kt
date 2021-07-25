package com.example.tapasoft.testusersapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tapasoft.testusersapp.repository.DataRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserViewModelFactory @Inject constructor (val repository: DataRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(DataRepository::class.java).newInstance(repository)
    }
}