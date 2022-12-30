package com.ruangaldo.ruanggame.domain.repository

import com.ruangaldo.ruanggame.data.local.entity.GameItemEntities
import com.ruangaldo.ruanggame.util.wrapper.DataResource
import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

interface IGamesRepository {
    suspend fun fetchGameList(
        swipe: Boolean,
        network: Boolean
    ): Flow<DataResource<List<GameItemEntities>>>
}
