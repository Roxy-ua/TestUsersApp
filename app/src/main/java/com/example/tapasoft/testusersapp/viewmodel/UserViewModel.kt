package com.example.tapasoft.testusersapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tapasoft.testusersapp.model.User
import com.example.tapasoft.testusersapp.repository.DataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserViewModel(private val repository: DataRepository = DataRepository()) : ViewModel() {

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.IO
    private val scope = CoroutineScope(coroutineContext)

    val userLiveData = MutableLiveData<List<User>>()

    fun fetchDataFromServer() {
        scope.launch {
            val userPage = repository.getUsers()
            if (userPage != null) {
                userLiveData.postValue(userPage.users)
            }
        }
    }
}