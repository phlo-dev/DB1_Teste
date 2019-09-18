package com.pedro.db1.teste.main.utils

import android.graphics.DashPathEffect
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.pedro.db1.teste.R

fun LineChart.setupWithData(values: List<Entry>) {
    setTouchEnabled(true)
    setPinchZoom(true)
    val dataSet: LineDataSet
    if (data?.dataSetCount ?: 0 > 0) {
        dataSet = data.getDataSetByIndex(0) as LineDataSet
        dataSet.values = values
        data.notifyDataChanged()
        notifyDataSetChanged()
    } else {
        dataSet = LineDataSet(values, "Cotação do Bitcoin").run {
            setDrawIcons(false)
            enableDashedLine(10f, 5f, 0f)
            enableDashedHighlightLine(10f, 5f, 0f)
            color = ContextCompat.getColor(context, R.color.aquaMarine)
            setCircleColor(ContextCompat.getColor(context, R.color.aquaMarine))
            lineWidth = 1f
            circleRadius = 4f
            setDrawCircleHole(false)
            valueTextSize = 14f
            setDrawFilled(true)
            formLineWidth = 1f
            formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
            formSize = 15f
            this
        }
        data = LineData(mutableListOf(dataSet) as List<ILineDataSet>?)
    }
}