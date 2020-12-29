package com.example.android4a.api

import com.example.android4a.domain.entity.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {
    @GET("posts")
    suspend fun getPost(): Response<List<Post>>
}