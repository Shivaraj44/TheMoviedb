package com.example.themoviedb.Search

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.themoviedb.R
import com.example.themoviedb.responce.ResultsItem
import com.example.themoviedb.moviedetailes.MovieDetailsActivity
import kotlinx.android.synthetic.main.fragment_search.*

/**
-Helps for search Operation and display the result in the in the recyclerview
 */
private lateinit var searchViewModel: SearchViewModel
private lateinit var searchAdapter: Search_Adapter

private val searchlist = emptyList<ResultsItem>()
class SearchFragment : Fragment(), ItemClickListener {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sv_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(p0: String): Boolean {
                if (p0 != null) {
                    searchViewModel.callAPI(p0)

                }
                return false
            }
        })
        searchViewModel = ViewModelProvider(requireActivity()).get(SearchViewModel::class.java)
        setRecyclerAdapter()
        observeLiveData()
    }
    private fun observeLiveData() {
        searchViewModel.liveData.observe(requireActivity(), {
            when (it) {
                is SearchUIModel.Success -> {
                    searchAdapter.updateDataList(it.SearchList)
                    progressBar.visibility = View.GONE
                }
                is SearchUIModel.Failure -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(
                        context,
                        "Error message ${it.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }
    private fun setRecyclerAdapter() {
        searchAdapter = Search_Adapter(searchlist, this)
        val layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        recyclerViewSearch.apply {
            adapter = searchAdapter
            this.layoutManager = layoutManager
        }
    }
    override fun onItemClicked(position: Int, resultsItem: ResultsItem) {
        val intent = Intent(context, MovieDetailsActivity::class.java)
        intent.putExtra("moiveId", resultsItem.id);
        startActivity(intent)
    }
}