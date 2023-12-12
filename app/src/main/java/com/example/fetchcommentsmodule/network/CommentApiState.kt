package com.example.fetchcommentsmodule.network

data class CommentApiState <out T>(val status: Status, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): CommentApiState<T> {
            return CommentApiState(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String): CommentApiState<T> {
            return CommentApiState(Status.ERROR, null, msg)
        }

        fun <T> loading(): CommentApiState<T> {
            return CommentApiState(Status.LOADING, null, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}