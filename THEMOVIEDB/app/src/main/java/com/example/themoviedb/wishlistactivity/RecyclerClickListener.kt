package com.example.themoviedb.wishlistactivity

import com.example.themoviedb.database.User

interface RecyclerClickListener {



    fun onDeleteClicked( user: User)
}