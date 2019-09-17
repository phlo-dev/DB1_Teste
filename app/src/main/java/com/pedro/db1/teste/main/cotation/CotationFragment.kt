package com.pedro.db1.teste.main.cotation


import android.graphics.Color.DKGRAY
import android.graphics.DashPathEffect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.pedro.db1.presentation.cotation.CotationViewModel
import com.pedro.db1.teste.R
import com.pedro.db1.teste.main.base.BaseFragment
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
        viewModel.getCotationViewState().handleWithFlow {
            cotationLineChart.setupWithData(it.mapIndexed { index, cotationValue ->
                Entry(index.toFloat(), cotationValue.amount, cotationValue.date)
            })
        }
    }

    override fun setupViews() {
        setupChart()
    }

    private fun setupChart() = cotationLineChart.run {
        setTouchEnabled(true)
        setPinchZoom(true)
    }

    private fun LineChart.setupWithData(values: List<Entry>) {
        val set1: LineDataSet
        if (data != null && data.dataSetCount > 0) {
            set1 = data.getDataSetByIndex(0) as LineDataSet
            set1.values = values
            data.notifyDataChanged()
            notifyDataSetChanged()
        } else {
            set1 = LineDataSet(values, "Cotação do Bitcoin")
            set1.setDrawIcons(false)
            set1.enableDashedLine(10f, 5f, 0f)
            set1.enableDashedHighlightLine(10f, 5f, 0f)
            set1.color = DKGRAY
            set1.setCircleColor(DKGRAY)
            set1.lineWidth = 1f
            set1.circleRadius = 3f
            set1.setDrawCircleHole(false)
            set1.valueTextSize = 9f
            set1.setDrawFilled(true)
            set1.formLineWidth = 1f
            set1.formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
            set1.formSize = 15f
            val drawable =
                ContextCompat.getDrawable(requireContext(), android.R.drawable.btn_dialog)
            set1.fillDrawable = drawable
            val dataSets = mutableListOf<LineDataSet>()
            dataSets.add(set1)
            val data = LineData(dataSets as List<ILineDataSet>?)
            setData(data)
        }
    }

    override fun onDestroy() {
        lifecycle.removeObserver(viewModel)
        super.onDestroy()
    }
}
