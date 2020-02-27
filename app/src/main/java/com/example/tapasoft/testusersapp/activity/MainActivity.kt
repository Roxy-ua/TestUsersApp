package com.example.tapasoft.testusersapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tapasoft.testusersapp.R
import com.example.tapasoft.testusersapp.adapter.UserListAdapter
import com.example.tapasoft.testusersapp.model.User
import com.example.tapasoft.testusersapp.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val KEY_USER_ID = "key_user_id"
    }
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider.NewInstanceFactory().create(UserViewModel::class.java)
        viewModel.fetchDataFromServer()

        viewModel.userLiveData.observe(this, Observer {
            userRecyclerView.layoutManager = LinearLayoutManager(this)
            userRecyclerView.adapter = UserListAdapter(it) {
                startUserDetailsActivity(it)
            }
        })
    }

    private fun startUserDetailsActivity(user: User) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(KEY_USER_ID, user)
        startActivity(intent)
    }

}
