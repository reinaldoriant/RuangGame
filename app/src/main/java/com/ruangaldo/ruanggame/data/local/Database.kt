package com.ruangaldo.ruanggame.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ruangaldo.ruanggame.data.local.converter.BitmapTypeConverter
import com.ruangaldo.ruanggame.data.local.converter.GenreTypeConverter
import com.ruangaldo.ruanggame.data.local.converter.PlatformTypeConverter
import com.ruangaldo.ruanggame.data.local.dao.RawgLocalDao
import com.ruangaldo.ruanggame.data.local.entity.GameItemEntities

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

object Database {
    @Database(
        entities = [GameItemEntities::class],
        version = 1
    )
    @TypeConverters(
        GenreTypeConverter::class,
        PlatformTypeConverter::class,
        BitmapTypeConverter::class
    )
    abstract class LocalDatabase : RoomDatabase() {
        abstract fun gameListDao(): RawgLocalDao
    }
}
