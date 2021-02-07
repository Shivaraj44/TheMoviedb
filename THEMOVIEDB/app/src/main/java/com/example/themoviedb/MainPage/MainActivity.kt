package com.example.themoviedb.MainPage

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
import com.example.themoviedb.Search.SearchFragment
import com.example.themoviedb.moviedetailes.MovieDetailsActivity
import com.example.themoviedb.responce.ResultsItem
import com.example.themoviedb.wishlistactivity.WishListActivity
import kotlinx.android.synthetic.main.activity_main.*


/**
-First Screen which contains the list of movies in recyclerview with the help of retrofit2.
-At the corner of each movie you can save the movies to watch later and at the top corner heart will
display the saved movie list.
-Search button to search any movies from the list.
 */
class MainActivity : AppCompatActivity(), Main_Listner {


    private lateinit var mainViewModel: Main_ViewModel
    private lateinit var mainAdapter: Main_Adapter
    private val dataModelList = emptyList<ResultsItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(Main_ViewModel::class.java)

        setRecyclerAdapter()

        observeLiveData()
        select()

        //passing to new Activity where it will display the list of saved movies
        show_watchlist.setOnClickListener(View.OnClickListener {
            val intent1 = Intent(this, WishListActivity::class.java)
            startActivity(intent1)
        })

// Will take you to a fragment to do the search operation
        searchview.setOnClickListener(View.OnClickListener {
            callFragment()
        })
    }

    fun callFragment() {
        val fragment = SearchFragment()
        supportFragmentManager.beginTransaction().add(
            R.id.relativeLayoyt_fragment, fragment,
            "fragment search"
        ).addToBackStack("frag").commit()
    }


    //getting the list of movies from Viewmodel via liveData and observing
    private fun observeLiveData() {
        mainViewModel.liveData.observe(this, {
            when (it) {
                is Main_UIModel.Success -> {
                    mainAdapter.updateList(it.dataModelList)
                    //   flProgressBar.visibility = View.GONE
                }

                is Main_UIModel.Failure -> {
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


    //Setting the Adapter and Layout Manager to the recyclerview
    private fun setRecyclerAdapter() {
        mainAdapter = Main_Adapter(dataModelList, this)
        val layoutManager = GridLayoutManager(this, 2)
        recycler_view.apply {
            this.layoutManager = layoutManager
            adapter = mainAdapter
        }
    }


//On Click of any item in the screen will open a new Activity to display the information about the movie
    override fun Onclick(resultsItem: ResultsItem) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("img_path", resultsItem.posterPath)
        intent.putExtra("title", resultsItem.title)
        intent.putExtra("dis", resultsItem.overview)
        intent.putExtra("star", resultsItem.voteCount)

        startActivity(intent)


    }

//Used to Select the different type of movies accordingly
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

                    mainViewModel.callAPI0()

                } else if (position == 1) {

                    mainViewModel.callAPI1()
                } else if (position == 2) {

                    mainViewModel.callAPI2()

                } else if (position == 3) {
                    mainViewModel.callAPI3()
                }
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0) {

                    mainViewModel.callAPI0()

                } else if (position == 1) {

                    mainViewModel.callAPI1()
                } else if (position == 2) {

                    mainViewModel.callAPI2()

                } else if (position == 3) {
                    mainViewModel.callAPI3()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

    }

}