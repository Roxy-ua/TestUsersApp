package com.example.tapasoft.testusersapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tapasoft.testusersapp.R
import com.example.tapasoft.testusersapp.model.User
import com.squareup.picasso.Picasso


class UserListAdapter(var items: List<User>, val listener: (User) -> Unit)
    : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: User = items[position]
        holder.bind(user, listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class UserViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.user_list_item, parent, false)) {

        private var nameView: TextView? = null
        private var photoView: ImageView? = null

        init {
            nameView = itemView.findViewById(R.id.name)
            photoView = itemView.findViewById(R.id.photo)
        }

        fun bind(user: User, listener: (User) -> Unit) = with(itemView) {
            nameView?.text = user.name.first + " " + user.name.last
            val photoUrl = user.picture.thumbnail
            Picasso.get().load(photoUrl).placeholder(R.drawable.bill_up_close).into(photoView)

            setOnClickListener {
                listener(user)
            }
        }
    }
}