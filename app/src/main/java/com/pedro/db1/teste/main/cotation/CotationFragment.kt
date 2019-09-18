package com.pedro.db1.teste.main.cotation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.data.Entry
import com.pedro.db1.presentation.cotation.CotationViewModel
import com.pedro.db1.presentation.model.CotationField
import com.pedro.db1.teste.R
import com.pedro.db1.teste.main.base.BaseFragment
import com.pedro.db1.teste.main.utils.hideWithFade
import com.pedro.db1.teste.main.utils.setupWithData
import com.pedro.db1.teste.main.utils.showWithFade
import kotlinx.android.synthetic.main.fragment_cotation.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CotationFragment : BaseFragment() {
    private val viewModel: CotationViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_cotation, container, false)

    override fun creatingObservers() {
        lifecycle.addObserver(viewModel)
        viewModel.getCotationViewState().handleWithFlow(
            onLoading = { cotationLoading.showWithFade() },
            onComplete = { cotationLoading.hideWithFade() },
            onSuccess = {
                cotationLineChart.showWithFade()
                cotationLineChart.setupWithData(it.mapSafelyToEntryData())
            }
        )
    }

    private fun List<CotationField>.mapSafelyToEntryData() =
        try {
            map {
                Entry(it.date.toFloat(), it.amount, it.date)
            }.subList(0, 10)
        } catch (ignored: Exception) {
            listOf<Entry>()
        }

    override fun onDestroy() {
        lifecycle.removeObserver(viewModel)
        super.onDestroy()
    }
}
