package com.example.themoviedb.MainPage

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviedb.database.User
import com.example.themoviedb.database.UserDatabase
import com.example.themoviedb.responce.ResultsItem
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Main_ViewHolder(private val view: View, var mainListner: Main_Listner) : RecyclerView.ViewHolder(view) {

    fun setData(dataModel: ResultsItem) {
        view.apply {
            Glide.with(image_view).load(
                "https://image.tmdb.org/t/p/w500/" +
                        dataModel.posterPath
            ).into(image_view)
            title.text = dataModel.title

            libear_layout.setOnClickListener {
                mainListner.Onclick(dataModel)
            }
            checkbox.setOnCheckedChangeListener { checkBox, isChecked ->

                if (isChecked) {

                    CoroutineScope(Dispatchers.IO).launch {
                        val user =
                            User(
                                title = dataModel.title.toString(),
                                image = dataModel.posterPath.toString()
                            )
                        UserDatabase.getInstance(context).userDao.insertUser(user)
                    }
                } else {

                    //deleteUser(user)


                }
            }

        }
//    }
//    fun deleteUser(user: User) {
//        CoroutineScope(IO).launch {
//            UserDatabase.getInstance(context).userDao
//                .deleteUser(user)
//        }
//    }
    }
}