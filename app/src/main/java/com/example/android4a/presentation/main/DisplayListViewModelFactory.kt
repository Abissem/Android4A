package com.example.android4a.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android4a.data.repository.Repository

class DisplayListViewModelFactory(
    private val repository: Repository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DisplayListViewModel(repository) as T
    }

}