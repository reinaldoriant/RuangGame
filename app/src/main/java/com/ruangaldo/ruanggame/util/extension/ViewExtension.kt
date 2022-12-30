package com.ruangaldo.ruanggame.util.extension

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

/**
 * Written with joy and smile by Ruang Aldo on 30/12/22.
 * Github: https://github.com/reinaldoriant
 */

object ViewExtension {
    fun Context.getImageDrawable(drawable: Int): Drawable? =
        ContextCompat.getDrawable(this, drawable)
}
