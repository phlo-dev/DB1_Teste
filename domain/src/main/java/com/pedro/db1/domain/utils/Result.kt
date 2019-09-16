package com.pedro.db1.domain.utils

sealed class Result<out T> {
    class Success<out T>(val data: T) : Result<T>()
    class Failure(val throwable: Throwable) : Result<Nothing>()

    suspend fun <B> flatMap(
        onFailure: suspend (Throwable) -> Result<B> = { Failure(it) },
        onSuccess: suspend (T) -> Result<B>
    ): Result<B> =
        when (this) {
            is Success -> onSuccess(data)
            is Failure -> onFailure(throwable)
        }

    suspend fun <B> map(
        onFailure: suspend (Throwable) -> Throwable = { it },
        onSuccess: suspend (T) -> B
    ): Result<B> = when (this) {
        is Success -> Success(onSuccess(data))
        is Failure -> Failure(onFailure(throwable))
    }

}