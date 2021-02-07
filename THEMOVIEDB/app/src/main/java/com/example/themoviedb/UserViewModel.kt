package com.example.themoviedb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel(), Callback<ResponseTrending> {

    private val repository = UserRepository(this)

    private val mutableLiveData = MutableLiveData<UserUIModel>()

    val liveData: LiveData<UserUIModel> = mutableLiveData

    /**
     * This method is called once the response is received from the API
     */
    override fun onResponse(call: Call<ResponseTrending>, response: Response<ResponseTrending>) {
        response.body()?.let {
            mutableLiveData.value = UserUIModel.Success(it.results as List<ResultsItem>)
        }
    }

    /**
     * If the API response fails due to some reason this method gets invoked
     */
    override fun onFailure(call: Call<ResponseTrending>, t: Throwable) {
        mutableLiveData.value = UserUIModel.Failure(t.message!!)
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