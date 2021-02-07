package com.example.themoviedb.wishlistactivity

import com.example.themoviedb.database.User
/**
On each itm clicked from the User Database
 */
interface WishList_ClickListener {



    fun onDeleteClicked( user: User)
}