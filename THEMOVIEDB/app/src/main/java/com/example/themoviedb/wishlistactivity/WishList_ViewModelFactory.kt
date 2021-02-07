package com.example.themoviedb.wishlistactivity

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
/**
providing the context to the viewModel

 */
class WishList_ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WishList_ViewModel::class.java)) {
            return WishList_ViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}