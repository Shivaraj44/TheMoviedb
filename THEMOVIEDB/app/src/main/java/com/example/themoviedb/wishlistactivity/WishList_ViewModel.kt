package com.example.themoviedb.wishlistactivity

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.themoviedb.database.User
import com.example.themoviedb.database.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
/**
Performing the inserting and deleting of the movie list to database

 */
class WishList_ViewModel(private val context: Context) : ViewModel() {


    fun fetchDataFromDB(): LiveData<List<User>> {
        return UserDatabase.getInstance(context)
            .userDao.getAllUsers()
    }


    fun deleteUser(user: User) {
        CoroutineScope(IO).launch {
            UserDatabase.getInstance(context).userDao
                .deleteUser(user)
        }
    }
}