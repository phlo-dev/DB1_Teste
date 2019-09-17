package com.pedro.db1.presentation.cotation

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.pedro.db1.domain.usecase.cotation.CotationUseCase
import com.pedro.db1.presentation.*
import com.pedro.db1.presentation.mapper.toUiModel
import com.pedro.db1.presentation.model.CotationField
import com.pedro.db1.presentation.utils.useCase
import org.koin.standalone.KoinComponent

class CotationViewModel : ViewModel(), KoinComponent, LifecycleObserver {
    private val cotationUseCase: CotationUseCase by useCase()
    private val cotationViewState = createViewState<List<CotationField>>()
    private val cotationValueList = mutableListOf<CotationField>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun fetchCotations() = cotationUseCase.execute(
        "5weeks",
        onSuccess = {
            val list = it.toUiModel()
            cotationValueList.clear()
            cotationValueList.addAll(list)
            cotationViewState.postSuccess(list)
        },
        onFailure = { cotationViewState.postFailure(it) }
    )

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopAll() {
        cotationViewState.postNeutral()
    }

    override fun onCleared() {
        cotationUseCase.cancel()
        super.onCleared()
    }

    fun getCotationViewState() = cotationViewState.asLiveData()
}