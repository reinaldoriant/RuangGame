package com.ruangaldo.ruanggame.data.local.datasource

import com.ruangaldo.ruanggame.data.local.dao.RawgLocalDao
import com.ruangaldo.ruanggame.data.local.entity.GameItemEntities
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

@Singleton
class RawgLocalDataSourceImpl @Inject constructor(private val dao: RawgLocalDao) {
    fun loadGameList(): Flow<List<GameItemEntities>> = dao.loadGameList()
    suspend fun insertGameList(data: List<GameItemEntities>) = dao.insertGameList(data)
}
