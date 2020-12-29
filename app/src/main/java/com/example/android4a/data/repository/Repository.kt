package com.example.android4a.data.repository

import com.example.android4a.api.RetrofitInstance
import com.example.android4a.domain.entity.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<List<Post>> {
        return RetrofitInstance.api.getPost()

    }
}