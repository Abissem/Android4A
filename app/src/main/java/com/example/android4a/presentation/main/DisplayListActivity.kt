package com.example.android4a.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android4a.R
import com.example.android4a.adapter.MyAdapter
import com.example.android4a.data.repository.Repository
import kotlinx.android.synthetic.main.activity_display_list.*

class DisplayListActivity : AppCompatActivity() {

    private lateinit var viewModel: DisplayListViewModel
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_list)

        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = DisplayListViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DisplayListViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let {myAdapter.setData(it)}
            }else{
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun setupRecyclerview(){
        recyclerview.adapter = myAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}