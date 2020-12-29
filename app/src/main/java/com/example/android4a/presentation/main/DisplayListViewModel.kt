package com.example.android4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a.data.repository.Repository
import com.example.android4a.domain.entity.Post
import kotlinx.coroutines.launch
import retrofit2.Response

class DisplayListViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

}