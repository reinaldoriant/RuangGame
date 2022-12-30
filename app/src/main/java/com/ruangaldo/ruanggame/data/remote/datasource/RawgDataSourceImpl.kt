package com.ruangaldo.ruanggame.data.remote.datasource

import com.ruangaldo.ruanggame.data.remote.dto.GetGameListDto
import com.ruangaldo.ruanggame.data.remote.services.RawgService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

@Singleton
class RawgDataSourceImpl @Inject constructor(private val service: RawgService) {
    suspend fun fetchGameList(): GetGameListDto = service.fetchGameList()
}
