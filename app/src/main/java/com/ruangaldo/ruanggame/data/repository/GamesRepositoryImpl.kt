package com.ruangaldo.ruanggame.data.repository

import com.ruangaldo.ruanggame.data.local.datasource.RawgLocalDataSourceImpl
import com.ruangaldo.ruanggame.data.local.entity.GameItemEntities
import com.ruangaldo.ruanggame.data.mapper.GameDtoMapper
import com.ruangaldo.ruanggame.data.remote.datasource.RawgDataSourceImpl
import com.ruangaldo.ruanggame.data.remote.dto.GetGameListDto
import com.ruangaldo.ruanggame.domain.repository.IGamesRepository
import com.ruangaldo.ruanggame.util.network.NetworkBoundResource
import com.ruangaldo.ruanggame.util.wrapper.DataResource
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

@Singleton
class GamesRepositoryImpl @Inject constructor(
    private val remote: RawgDataSourceImpl,
    private val local: RawgLocalDataSourceImpl
) : IGamesRepository, BaseRepository() {
        override suspend fun fetchGameList(
            swipe: Boolean,
            network: Boolean
        ): Flow<DataResource<List<GameItemEntities>>> {
            return object : NetworkBoundResource<List<GameItemEntities>, GetGameListDto>() {
                override suspend fun loadFromDB(): Flow<List<GameItemEntities>> =
                    local.loadGameList()

                override suspend fun shouldFetch(data: List<GameItemEntities>?): Boolean =
                    swipe || data == null || network

                override suspend fun createCall(): DataResource<GetGameListDto> =
                    safeNetworkCall {
                        remote.fetchGameList()
                    }

            override suspend fun saveCallResult(data: GetGameListDto) {
                val gameListData = GameDtoMapper.toGameListEntities(data)
                local.insertGameList(gameListData)
            }
        }.asFlow()
    }
}
