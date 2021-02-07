package com.example.themoviedb.Search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themoviedb.responce.ResultsItem
import com.example.themoviedb.responce.Response
import retrofit2.Call
import retrofit2.Callback

class SearchViewModel : ViewModel(), Callback<Response> {
    private val repository = SearchRepository(this)
    private val mutableLiveData = MutableLiveData<SearchUIModel>()
    val liveData: LiveData<SearchUIModel> = mutableLiveData
    override fun onResponse(call: Call<Response>, response: Response<Response>) {
        response.body()?.let {
            mutableLiveData.value = SearchUIModel.Success(it.results as List<ResultsItem>)
        }
    }
    override fun onFailure(call: Call<Response>, t: Throwable) {
        mutableLiveData.value = SearchUIModel.Failure(t.message!!)
    }
    fun callAPI(p0: String) {
        repository.getListofSearch(p0)
    }
}