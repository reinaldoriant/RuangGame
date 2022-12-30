package com.ruangaldo.ruanggame.util.extension

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar

/**
 * Written with joy and smile by Ruang Aldo on 30/12/22.
 * Github: https://github.com/reinaldoriant
 */

object ViewExtension {
    fun Context.getImageDrawable(drawable: Int): Drawable? =
        ContextCompat.getDrawable(this, drawable)

    fun View.visible() {
        visibility = View.VISIBLE
    }

    fun View.gone() {
        visibility = View.GONE
    }

    fun SwipeRefreshLayout.hideLoading() {
        this.isRefreshing = false
    }
}
