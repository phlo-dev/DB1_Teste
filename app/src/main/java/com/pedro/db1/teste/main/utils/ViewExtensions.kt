package com.pedro.db1.teste.main.utils

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewPropertyAnimator
import android.view.animation.AccelerateDecelerateInterpolator

fun View.show() {
    visibility = VISIBLE
}

fun View.hide(visibility: Int = GONE) {
    this.visibility = visibility
}

fun View.animateWithAlpha(alpha: Float, duration: Long = 500): ViewPropertyAnimator =
    animate()
        .alpha(alpha)
        .setDuration(duration)
        .setInterpolator(AccelerateDecelerateInterpolator())


fun View.hideWithFade(visibility: Int = GONE, duration: Long = 500) =
    animateWithAlpha(0f, duration).scaleX(0f).scaleY(0f).withEndAction {
        hide(visibility)
    }.start()

fun View.showWithFade(duration: Long = 500) =
    animateWithAlpha(1f, duration).scaleX(1f).scaleY(1f).withStartAction {
        alpha = 0f
        show()
    }.start()
