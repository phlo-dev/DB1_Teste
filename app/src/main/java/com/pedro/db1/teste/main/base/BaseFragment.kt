package com.pedro.db1.teste.main.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.pedro.db1.presentation.handleWithFlow
import com.pedro.db1.presentation.utils.ViewState

open class BaseFragment : Fragment() {

    open fun handleErrors(throwable: Throwable) {
        Toast.makeText(requireContext(), throwable.message ?: "", Toast.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        creatingObservers()
    }

    open fun setupViews(){}

    open fun creatingObservers(){}

    fun <T> LiveData<ViewState<T>>.handleWithFlow(
        onNeutral: () -> Unit = {},
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