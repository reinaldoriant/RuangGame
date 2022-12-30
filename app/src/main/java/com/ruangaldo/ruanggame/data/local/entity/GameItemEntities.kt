package com.ruangaldo.ruanggame.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.ruangaldo.ruanggame.data.local.converter.GenreTypeConverter
import com.ruangaldo.ruanggame.data.local.converter.PlatformTypeConverter

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

@Entity(tableName = "game_list_table")
data class GameItemEntities(
    @PrimaryKey
    @ColumnInfo(name = "page")
    val id: Int? = 0,
    @ColumnInfo(name = "image")
    val image: String? = "",
    @ColumnInfo(name = "title")
    val title: String? = "",
    @ColumnInfo(name = "platform")
    @TypeConverters(PlatformTypeConverter::class) val platform: List<PlatformEntity>? = emptyList(),
    @ColumnInfo(name = "release")
    val release: String? = "",
    @ColumnInfo(name = "genres")
    @TypeConverters(GenreTypeConverter::class) val genres: List<GenreEntity>? = emptyList()
)

data class GenreEntity(
    @ColumnInfo(name = "id") val id: Int? = 0,
    @ColumnInfo(name = "name") val name: String? = "",
    @ColumnInfo(name = "slug") val slug: String? = "",
    @ColumnInfo(name = "image") val image: String? = ""
)

data class PlatformEntity(
    @ColumnInfo(name = "id") val id: Int? = 0,
    @ColumnInfo(name = "name") val name: String? = "",
    @ColumnInfo(name = "slug") val slug: String? = "",
)
