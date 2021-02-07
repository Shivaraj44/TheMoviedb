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

    @Query("Select * From Users")
    fun getAllUsers(): LiveData<List<User>>

    @Delete
    fun deleteUser(user: User)
}