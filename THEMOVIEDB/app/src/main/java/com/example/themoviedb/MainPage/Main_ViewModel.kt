package com.example.themoviedb.MainPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themoviedb.responce.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 Intermediate class between Model and View which contains live data
 which will update the view as soon as the result is absorbed by Model class

 */
class Main_ViewModel : ViewModel(), Callback<com.example.themoviedb.responce.Response> {

    private val repository = Main_Repository(this)

    private val mutableLiveData = MutableLiveData<Main_UIModel>()

    val liveData: LiveData<Main_UIModel> = mutableLiveData

    /**
     * This method is called once the response is received from the API
     */
    override fun onResponse(call: Call<com.example.themoviedb.responce.Response>, response: Response<com.example.themoviedb.responce.Response>) {
        response.body()?.let {
            mutableLiveData.value = Main_UIModel.Success(it.results as List<ResultsItem>)
        }
    }

    /**
     * If the API response fails due to some reason this method gets invoked
     */
    override fun onFailure(call: Call<com.example.themoviedb.responce.Response>, t: Throwable) {
        mutableLiveData.value = Main_UIModel.Failure(t.message!!)
    }

    /**
     * This method makes an API call to the Repository class where actual API call is made
     */
    fun callAPI0() {
        repository.getListOfModel0()
    }
    fun callAPI1() {
        repository.getListOfModel1()
    }
    fun callAPI2() {
        repository.getListOfModel2()
    }
    fun callAPI3() {
        repository.getListOfModel3()
    }
}