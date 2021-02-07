package com.example.themoviedb.wishlistactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.R
import com.example.themoviedb.database.User
/**
-Adjusting the adapter from viewhomder to list of data
-update the adapter using itemsetchanged
 */
class WishList_Adapter(
    private var usersList: List<User>,

    private val listener: WishList_ClickListener
) :
    RecyclerView.Adapter<WishList_ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishList_ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.wishlist_item_select, parent, false)
        return WishList_ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: WishList_ViewHolder, position: Int) {
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