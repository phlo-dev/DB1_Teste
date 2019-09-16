package com.pedro.db1.teste.main.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.pedro.db1.presentation.handleWithFlow
import com.pedro.db1.presentation.utils.ViewState

open class BaseFragment : Fragment() {

    open fun handleErrors(throwable: Throwable) {
        //TODO
    }

    fun <T> LiveData<ViewState<T>>.handleWithFlow(
        onNeutral: () -> Unit,
        onLoading: () -> Unit = {},
        onFailure: (Throwable) -> Unit = {},
        onComplete: (() -> Unit) = {},
        onSuccess: (T) -> Unit
    ) = this.handleWithFlow(
        this@BaseFragment,
        onNeutral,
        onLoading,
        onFailure,
        onComplete,
        onSuccess
    )


}