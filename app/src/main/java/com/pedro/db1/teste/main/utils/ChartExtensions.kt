package com.pedro.db1.teste.main.utils

import android.graphics.DashPathEffect
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.pedro.db1.teste.R
import java.text.SimpleDateFormat
import java.util.*

fun LineChart.setupWithData(values: List<Entry>) {
    val dataSet: LineDataSet
    dataSet = LineDataSet(values, "Cotação do Bitcoin").run {
        setDrawIcons(false)
        enableDashedLine(10f, 5f, 0f)
        enableDashedHighlightLine(10f, 5f, 0f)
        color = ContextCompat.getColor(context, R.color.aquaMarine)
        setCircleColor(ContextCompat.getColor(context, R.color.aquaMarine))
        lineWidth = 1f
        circleRadius = 4f
        setDrawCircleHole(false)
        valueTextSize = 16f
        setDrawFilled(true)
        xAxis.valueFormatter = object : DefaultAxisValueFormatter(5) {
            override fun getFormattedValue(value: Float): String = try {
                Date(value.toLong()).formatByMonthAndDay()
            } catch (ignored: Exception) {
                value.toString()
            }
        }
        formLineWidth = 1f
        formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
        formSize = 15f
        this
    }
    data = LineData(mutableListOf(dataSet) as List<ILineDataSet>?)
    invalidate()
}

fun Date.formatByMonthAndDay(): String = SimpleDateFormat(
    "dd'/'MM", Locale("pt", "BR")
).format(this)