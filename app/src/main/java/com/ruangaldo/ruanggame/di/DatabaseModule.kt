package com.ruangaldo.ruanggame.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import com.ruangaldo.ruanggame.data.local.Database.LocalDatabase
import com.ruangaldo.ruanggame.data.local.dao.RawgLocalDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): LocalDatabase =
        Room.databaseBuilder(context.applicationContext, LocalDatabase::class.java, "local.db")
            .build()

    @Provides
    fun provideGameListDao(database: LocalDatabase): RawgLocalDao =
        database.gameListDao()

}
