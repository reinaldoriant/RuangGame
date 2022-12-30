package com.ruangaldo.ruanggame.data.local.converter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream
import java.util.Base64


/**
 * Written with joy and smile by Ruang Aldo on 30/12/22.
 * Github: https://github.com/reinaldoriant
 */

object BitmapTypeConverter {
    @RequiresApi(VERSION_CODES.O)
    @TypeConverter
    fun toString(bitmap: Bitmap): String {
        val baOs = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baOs)
        val byte: ByteArray = baOs.toByteArray()
        return Base64.getEncoder().encodeToString(byte)
    }

    @RequiresApi(VERSION_CODES.O)
    @TypeConverter
    fun toBitMap(encodedString: String?): Bitmap? {
        return try {
            val encodeByte: ByteArray = Base64.getDecoder().decode(encodedString)
            val bitmap: Bitmap? = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
            bitmap
        } catch (e: Exception) {
            e.message
            null
        }
    }
}
