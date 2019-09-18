package com.pedro.db1.teste.main.utils

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.AccelerateInterpolator

fun View.show() {
    visibility = VISIBLE
}

fun View.hide(visibility: Int = GONE) {
    this.visibility = visibility
}

fun View.showWithFade(duration: Long = 200) = animate().run {
    this.interpolator = AccelerateInterpolator()
    this.duration = duration
    this.alpha(1f)
    this.scaleX(1f)
    this.scaleY(1f)
    withStartAction {
        if (visibility != VISIBLE) this@showWithFade.alpha = 0f
    }
    start()
}

fun View.hideWithFade(duration: Long = 200, visibility: Int = GONE) = animate().run {
    this.interpolator = AccelerateInterpolator()
    this.duration = duration
    this.alpha(0f)
    this.scaleX(0f)
    this.scaleY(0f)
    withEndAction {
        alpha = 1f
        hide(visibility)
    }
    start()
}