package com.pedro.db1.domain.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

abstract class UseCase<P, R> : KoinComponent {
    private val scope: CoroutineScope by inject()
    private val threadContextProvider: ThreadContextProvider by inject()

    protected abstract suspend fun call(params: P): Result<R>

    fun execute(
        params: P,
        onSuccess: (R) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        scope.launch(threadContextProvider.io) {
            val result = call(params)
            withContext(threadContextProvider.main) {
                when (result) {
                    is Result.Success -> onSuccess(result.data)
                    is Result.Failure -> onFailure(result.throwable)
                }
            }
        }
    }

    fun cancel() = scope.coroutineContext.cancel()
}