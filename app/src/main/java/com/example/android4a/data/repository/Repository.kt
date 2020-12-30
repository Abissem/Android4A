package com.example.android4a.data.repository

import com.example.android4a.data.remote.api.RetrofitInstance
import com.example.android4a.domain.entity.Episode
import retrofit2.Response

class Repository {

    suspend fun getPost(number: Int): Response<List<Episode>> {
        return RetrofitInstance.api.getPost(number)
    }
}