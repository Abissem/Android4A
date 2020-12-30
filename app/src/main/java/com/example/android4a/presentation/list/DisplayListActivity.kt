package com.example.android4a.presentation.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android4a.R
import com.example.android4a.adapter.MyAdapter
import com.example.android4a.data.repository.Repository
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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

        button.setOnClickListener {
            val myNumber= season_search.text.toString()
            if(Integer.parseInt(myNumber) in 1..30) {
                viewModel.getPost(Integer.parseInt(myNumber))
                viewModel.myResponse.observe(this, Observer { response ->
                    if (response.isSuccessful) {
                        response.body()?.let { myAdapter.setData(it) }
                    }
                })
            } else {
                MaterialAlertDialogBuilder(this)
                        .setTitle("D'OH !")
                        .setMessage("Il n'y a que 30 saisons ! Ecrit donc un nombre entre 1 et 30. Et apporte moi une Duff ou j'tétrangle !")
                        .setPositiveButton("Ok") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
            }
        }
    }
    private fun setupRecyclerview(){
        recyclerview.adapter = myAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}