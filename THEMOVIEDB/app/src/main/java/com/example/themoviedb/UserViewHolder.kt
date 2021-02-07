package com.example.themoviedb

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviedb.database.User
import com.example.themoviedb.database.UserDatabase
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserViewHolder(private val view: View,var listner: Listner) : RecyclerView.ViewHolder(view) {

    fun setData(dataModel: ResultsItem) {
        view.apply {
            Glide.with(image_view).load(
                "https://image.tmdb.org/t/p/w500/" +
                        dataModel.posterPath
            ).into(image_view)
            title.text = dataModel.title

            libear_layout.setOnClickListener {
                listner.Onclick(dataModel)
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