package com.ruangaldo.ruanggame.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ruangaldo.ruanggame.data.local.entity.GameItemEntities
import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

@Dao
interface RawgLocalDao {
    @Query("SELECT * FROM game_list_table ORDER BY `release` DESC")
    fun loadGameList(): Flow<List<GameItemEntities>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameList(data: List<GameItemEntities>)
}
