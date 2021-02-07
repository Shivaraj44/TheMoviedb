package com.example.themoviedb

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.themoviedb.*
import com.example.themoviedb.moviedetailes.MovieDetailsActivity
import com.example.themoviedb.wishlistactivity.WishListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Listner {


    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter
    private val dataModelList = emptyList<ResultsItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        selectwishlist()
        setRecyclerAdapter()

        observeLiveData()
        select()
        //   flProgressBar.visibility = View.VISIBLE

        show_watchlist.setOnClickListener(View.OnClickListener {
            val intent1 = Intent(this, WishListActivity::class.java)
            startActivity(intent1)
        })
    }

    private fun observeLiveData() {
        userViewModel.liveData.observe(this, {
            when (it) {
                is UserUIModel.Success -> {
                    userAdapter.updateList(it.dataModelList)
                    //   flProgressBar.visibility = View.GONE
                }

                is UserUIModel.Failure -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Error message ${it.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                    //  flProgressBar.visibility = View.GONE
                }
            }
        })
    }

    private fun setRecyclerAdapter() {
        userAdapter = UserAdapter(dataModelList, this)
        val layoutManager = GridLayoutManager(this, 2)
        recycler_view.apply {
            this.layoutManager = layoutManager
            adapter = userAdapter
        }
    }

    override fun Onclick(resultsItem: ResultsItem) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("img_path", resultsItem.posterPath)
        intent.putExtra("title", resultsItem.title)
        intent.putExtra("dis", resultsItem.overview)
        intent.putExtra("star", resultsItem.voteCount)

        startActivity(intent)


    }

    fun selectwishlist() {

    }

    fun select() {
        val option = arrayOf(
            "Popular",
            "Top Rated",
            "Up-Coming",
            "Now Playing"
        )
        spinner.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option)
        spinner.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0) {

                    userViewModel.callAPI0()

                } else if (position == 1) {

                    userViewModel.callAPI1()
                } else if (position == 2) {

                    userViewModel.callAPI2()

                }else if(position==3){
                    userViewModel.callAPI3()
                }
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0) {

                    userViewModel.callAPI0()

                } else if (position == 1) {

                    userViewModel.callAPI1()
                } else if (position == 2) {

                    userViewModel.callAPI2()

                }else if(position==3){
                    userViewModel.callAPI3()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

    }

}