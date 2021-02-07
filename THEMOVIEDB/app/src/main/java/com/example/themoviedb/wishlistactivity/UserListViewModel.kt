package com.example.themoviedb.wishlistactivity

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.themoviedb.database.User
import com.example.themoviedb.database.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserListViewModel(private val context: Context) : ViewModel() {

    /**
     * This will fetch the list of users from database and notify the activity with the help of
     * live data
     */
    fun fetchDataFromDB(): LiveData<List<User>> {
        return UserDatabase.getInstance(context)
            .userDao.getAllUsers()
    }


    /**
     * Deletes a particular user from the database
     */
    fun deleteUser(user: User) {
        CoroutineScope(IO).launch {
            UserDatabase.getInstance(context).userDao
                .deleteUser(user)
        }
    }
}