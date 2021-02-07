package com.example.themoviedb.wishlistactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.R
import com.example.themoviedb.ResultsItem
import com.example.themoviedb.database.User

class UserListAdapter(
    private var usersList: List<User>,

    private val listener: RecyclerClickListener
) :
    RecyclerView.Adapter<UserListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.wishlist_item_select, parent, false)
        return UserListViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val user = usersList[position]
        holder.setData(user)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    fun updateData(userList: List<User>) {
        this.usersList = userList
        notifyDataSetChanged()
    }
}