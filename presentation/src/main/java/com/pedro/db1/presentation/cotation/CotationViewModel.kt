package com.pedro.db1.presentation.cotation

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.pedro.db1.domain.model.CotationValue
import com.pedro.db1.domain.usecase.cotation.CotationUseCase
import com.pedro.db1.presentation.*

class CotationViewModel(
    private val cotationUseCase: CotationUseCase
) : ViewModel(), LifecycleObserver {
    private val cotationViewState = createViewState<List<CotationValue>>()
    private val cotationValueList = mutableListOf<CotationValue>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun fetchCotations() {
        when(cotationValueList.isEmpty()) {
            true -> cotationUseCase.execute(
                "5weeks",
                onSuccess = { cotationViewState.postSuccess(it) },
                onFailure = { cotationViewState.postFailure(it) }
            )
            false -> cotationViewState.postSuccess(cotationValueList)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopAll(){
        cotationViewState.postNeutral()
    }

    override fun onCleared() {
        cotationUseCase.cancel()
        super.onCleared()
    }

    fun getCotationViewState() = cotationViewState.asLiveData()
}