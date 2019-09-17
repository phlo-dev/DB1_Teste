package com.pedro.db1.data_remote

import com.pedro.db1.domain.utils.Response

suspend fun <T> apiCall(call: suspend () -> T) = try {
    Response.Success(call())
} catch (t: Throwable) {
    Response.Failure(t)
}