package com.ruangaldo.ruanggame.data.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ruangaldo.ruanggame.data.local.entity.GenreEntity

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

object GenreTypeConverter {
    private var gson = Gson()

    @TypeConverter
    fun fromSource(data: List<GenreEntity>): String = gson.toJson(data)

    @TypeConverter
    fun toSource(data: String): List<GenreEntity> {
        return try {
            listOf(gson.fromJson(data, GenreEntity::class.java))
        } catch (e: Exception) {
            arrayListOf()
        }
    }
}

