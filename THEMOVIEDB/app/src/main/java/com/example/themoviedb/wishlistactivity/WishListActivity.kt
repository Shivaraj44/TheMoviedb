package com.example.themoviedb.wishlistactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.themoviedb.R
import com.example.themoviedb.database.User
import kotlinx.android.synthetic.main.activity_wish_list.*

class WishListActivity : AppCompatActivity() ,WishList_ClickListener{

    private var userList = emptyList<User>()
    private lateinit var wishListAdapter: WishList_Adapter
    private lateinit var wishListViewModel: WishList_ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wish_list)

        wishListViewModel = WishList_ViewModelFactory(this).create(WishList_ViewModel::class.java)


        wishListViewModel.fetchDataFromDB().observe(this, {
            it?.let {
                this@WishListActivity.userList = it
                wishListAdapter.updateData(userList)
            }
        })

        setRecyclerAdapter()
    }
    private fun setRecyclerAdapter() {
        wishListAdapter = WishList_Adapter(userList, this)
        val linearLayoutManager = GridLayoutManager(this,3)
        wishlist_recyclerview.layoutManager = linearLayoutManager
        wishlist_recyclerview.adapter = wishListAdapter
    }

    override fun onDeleteClicked( user: User) {
        wishListViewModel.deleteUser(user)
    }



}