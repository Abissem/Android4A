package com.example.android4a.data.remote.api

import com.example.android4a.domain.entity.Episode
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {
    /*@GET("posts")
    suspend fun getPost(): Response<List<Post>>*/

    @GET("episodes/s/{seasonNumber}")
    suspend fun getPost(
            @Path("seasonNumber") number: Int
    ): Response<List<Episode>>
}
