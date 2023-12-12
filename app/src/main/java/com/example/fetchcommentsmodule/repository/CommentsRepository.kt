package com.example.fetchcommentsmodule.repository

import com.example.fetchcommentsmodule.model.CommentModel
import com.example.fetchcommentsmodule.network.ApiService
import com.example.fetchcommentsmodule.network.CommentApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CommentsRepository(private val apiService: ApiService) {
    suspend fun getComment(id: Int): Flow<CommentApiState<CommentModel>> {
        return flow {

            // get the comment Data from the api
            val comment=apiService.getComments(id)

            // Emit this data wrapped in
            // the helper class [CommentApiState]
            emit(CommentApiState.success(comment))
        }.flowOn(Dispatchers.IO)
    }
}