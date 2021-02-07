package com.example.themoviedb.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    /*
    This will return a LiveData<List<Users>> , so whenever the database is changed the observer
    is notified
     */
    @Query("Select * From Users")
    fun getAllUsers(): LiveData<List<User>>



    @Delete
    fun deleteUser(user: User)
}