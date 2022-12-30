package com.ruangaldo.ruanggame.util.view

import android.content.Context
import android.widget.ImageView
import coil.load
import com.ruangaldo.ruanggame.util.extension.ViewExtension.getImageDrawable

/**
 * Written with joy and smile by Ruang Aldo on 30/12/22.
 * Github: https://github.com/reinaldoriant
 */

class CoilUtil {
    companion object CoilBuilder {
        fun buildUrl(
            context: Context,
            url: String,
            view: ImageView,
            scale: String? = "",
            placeholder: Int,
            isCrossfade: Boolean = false
        ) {
            try {
                if (scale == "CENTER_CROP") {
                    view.scaleType = ImageView.ScaleType.CENTER_CROP
                } else if (scale == "FIT_CENTER") {
                    view.scaleType = ImageView.ScaleType.FIT_CENTER
                }

                view.load(url) {
                    if (isCrossfade) {
                        crossfade(true)
                    }
                    placeholder(context.getImageDrawable(placeholder))
                }
            } catch (ex: Exception) {
                view.load(context.getImageDrawable(placeholder))
            }
        }


        /**
         * Function to display an image using image local integer
         *
         * @param context is Context
         * @param url is image local integer
         * @param view is ImageView
         * @param scale is image scale
         * @param placeholder is image placeholder
         * @param isInfographic is flag for infographic article
         * @param isSvg is flag for SVG image extension
         *
         * Input: context, url, view, scale, placeholder, isInfographic, isSvg
         * Output: Load image
         **/
        fun buildLocal(
            context: Context,
            url: Int,
            view: ImageView,
            scale: String? = "",
            placeholder: Int,
            isInfographic: Boolean = false,
            isSvg: Boolean = false
        ) {
            try {
                if (scale == "CENTER_CROP") {
                    view.scaleType = ImageView.ScaleType.CENTER_CROP
                } else if (scale == "FIT_CENTER") {
                    view.scaleType = ImageView.ScaleType.FIT_CENTER
                }

                view.load(url) {
                    placeholder(context.getImageDrawable(placeholder))
                }
            } catch (ex: Exception) {
                view.load(context.getImageDrawable(placeholder))
            }
        }
    }
}

