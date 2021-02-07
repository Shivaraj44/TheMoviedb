package com.example.themoviedb.wishlistactivity

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviedb.database.User
import kotlinx.android.synthetic.main.wishlist_item_select.view.*

class UserListViewHolder(
    private val view: View,
    private val listener: RecyclerClickListener
) : RecyclerView.ViewHolder(view) {

    fun setData(user: User) {
        view.apply {

            title.text = user.title
            Glide.with(image_view).load(
                "https://image.tmdb.org/t/p/w500/" +
                        user.image
            ).into(image_view)



            delet.setOnClickListener {
                listener.onDeleteClicked( user)
            }
        }
    }
}