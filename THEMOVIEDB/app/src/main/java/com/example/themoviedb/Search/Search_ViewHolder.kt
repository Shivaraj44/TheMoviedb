package com.example.themoviedb.Search

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviedb.responce.ResultsItem
import kotlinx.android.synthetic.main.wishlist_item_select.view.image_view

class Search_ViewHolder (private val view: View) : RecyclerView.ViewHolder(view) {
    fun setData(results: ResultsItem, itemClickListener: ItemClickListener) {
        view.apply {
            Glide.with(image_view).load("https://image.tmdb.org/t/p/w500/" + results.posterPath)
                .into(image_view)


//          tv_releaseDate.text = results.releaseDate
            //val voteCount : Int = results.voteAverage as Int

            image_view.setOnClickListener {
                Toast.makeText(context, results.posterPath, Toast.LENGTH_SHORT).show()
                itemClickListener.onItemClicked(adapterPosition, results)
            }
        }
    }
}