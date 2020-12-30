package com.example.android4a.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a.data.repository.Repository
import com.example.android4a.domain.entity.Episode
import kotlinx.coroutines.launch
import retrofit2.Response

class DisplayListViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<List<Episode>>> = MutableLiveData()

    fun getPost(number: Int) {
        viewModelScope.launch() {
            val response = repository.getPost(number)
            myResponse.value = response
        }
    }

}