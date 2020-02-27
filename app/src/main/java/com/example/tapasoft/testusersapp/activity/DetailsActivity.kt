package com.example.tapasoft.testusersapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tapasoft.testusersapp.R
import com.example.tapasoft.testusersapp.model.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val user: User? = intent.getParcelableExtra(MainActivity.KEY_USER_ID)

        if (user != null) {
            name.text = user.name.first + " " + user.name.last
            full_age.text = getString(R.string.years_old, user.dob.age)
            cell_phone.setText(user.cell)
            email.setText(user.email)
            location.setText(user.location.city + ", " + user.location?.state)

            val photoUrl = user.picture.large
            Picasso.get().load(photoUrl).placeholder(R.drawable.bill_up_close).into(big_photo)
        }
    }
}
