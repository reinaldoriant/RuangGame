package com.ruangaldo.ruanggame.data.remote.services

import com.ruangaldo.ruanggame.BuildConfig
import com.ruangaldo.ruanggame.data.remote.dto.GetGameListDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

interface RawgService {
    @GET("games")
    suspend fun fetchGameList(
        @Query("page") page: Int = 2,
        @Query("page_size") size: Int = 10,
        @Query("key") key: String = BuildConfig.API_KEY
    ): GetGameListDto
}
