package com.example.themoviedb.moviedetailes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.themoviedb.R
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.item.view.*

/**
 * Displays the selected movie information with starts and overview
 */
class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val path=intent.getStringExtra("img_path")
       val title= intent.getStringExtra("title")
       val overview1= intent.getStringExtra("dis")

        Glide.with(dsilpay_image).load("https://image.tmdb.org/t/p/w500/" +
                path).into(dsilpay_image)
        details_title.text=title
        overview.text=overview1
       val star=intent.getIntExtra("star",0)
        display_rating.text=star.toString()
    }
}