package com.ruangaldo.ruanggame.data.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ruangaldo.ruanggame.data.local.entity.GenreEntity
import com.ruangaldo.ruanggame.data.local.entity.PlatformEntity
import com.ruangaldo.ruanggame.data.remote.dto.Genre
import com.ruangaldo.ruanggame.data.remote.dto.Platform
import org.json.JSONObject

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

object PlatformTypeConverter {
    private var gson = Gson()

    @TypeConverter
    fun fromSource(data: List<PlatformEntity>): String = gson.toJson(data)

    @TypeConverter
    fun toSource(data: String): List<PlatformEntity> {
        return try {
            listOf(gson.fromJson(data, PlatformEntity::class.java))
        } catch (e: Exception) {
            arrayListOf()
        }
    }
}
