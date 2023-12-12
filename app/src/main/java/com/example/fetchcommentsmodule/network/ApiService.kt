package com.example.fetchcommentsmodule.network

import com.example.fetchcommentsmodule.model.CommentModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/comments/{id}")
    suspend fun getComments(@Path("id") id: Int): CommentModel
}