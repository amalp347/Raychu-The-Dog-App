package com.android.example.raychu.ui.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.android.example.raychu.R
import com.android.example.raychu.data.api.ApiHelper
import com.android.example.raychu.data.api.RetrofitBuilder
import com.android.example.raychu.data.model.response.breed
import com.android.example.raychu.ui.base.ViewModelFactory
import com.android.example.raychu.ui.main.adapter.MainAdapter
import com.android.example.raychu.ui.main.viewmodel.MainViewModel
import com.android.example.raychu.utils.Status
import kotlinx.android.synthetic.main.fragment_home.*

class DogListFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    companion object {
        fun newInstance(): DogListFragment {
            return DogListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setupViewModel()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
        setupUI()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.dogService))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = MainAdapter(arrayListOf()) { item ->
            findNavController().navigate(DogListFragmentDirections.actionHomeFragmentToDogDetailFragment(
                item?.description,item?.bredFor,item?.breedGroup, item?.temperament)
            )
        }
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getbreed().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { breeds -> retrieveList(breeds) }
                    }
                    Status.ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(breeds: List<breed>) {
        adapter.apply {
            addUsers(breeds)
            notifyDataSetChanged()
        }
    }
}
