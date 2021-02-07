package com.example.themoviedb.wishlistactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviedb.Listner
import com.example.themoviedb.R
import com.example.themoviedb.ResultsItem
import com.example.themoviedb.database.User
import com.example.themoviedb.moviedetailes.MovieDetailsActivity
import kotlinx.android.synthetic.main.activity_wish_list.*

class WishListActivity : AppCompatActivity() ,RecyclerClickListener{

    private var userList = emptyList<User>()
    private lateinit var userListAdapter: UserListAdapter
    private lateinit var userListViewModel: UserListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wish_list)
        userListViewModel = UserListViewModelFactory(this).create(UserListViewModel::class.java)


        userListViewModel.fetchDataFromDB().observe(this, {
            it?.let {
                this@WishListActivity.userList = it
                userListAdapter.updateData(userList)
            }
        })

        setRecyclerAdapter()
    }
    private fun setRecyclerAdapter() {
        userListAdapter = UserListAdapter(userList, this)
        val linearLayoutManager = GridLayoutManager(this,3)
        wishlist_recyclerview.layoutManager = linearLayoutManager
        wishlist_recyclerview.adapter = userListAdapter
    }

    override fun onDeleteClicked( user: User) {
        userListViewModel.deleteUser(user)
    }



}