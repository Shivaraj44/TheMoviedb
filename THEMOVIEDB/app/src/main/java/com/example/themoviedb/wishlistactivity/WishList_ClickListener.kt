package com.example.themoviedb.wishlistactivity

import com.example.themoviedb.database.User

interface WishList_ClickListener {



    fun onDeleteClicked( user: User)
}