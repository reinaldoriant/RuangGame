package com.ruangaldo.ruanggame.data

import com.nhaarman.mockitokotlin2.mock
import com.ruangaldo.ruanggame.data.local.datasource.RawgLocalDataSourceImpl
import com.ruangaldo.ruanggame.data.local.entity.GameItemEntities
import com.ruangaldo.ruanggame.data.remote.datasource.RawgDataSourceImpl
import com.ruangaldo.ruanggame.data.repository.GamesRepositoryImpl
import com.ruangaldo.ruanggame.util.wrapper.DataResource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Written with joy and smile by Ruang Aldo on 30/12/22.
 * Github: https://github.com/reinaldoriant
 */

class RawgRepositoryTest {
    private lateinit var repository: GamesRepositoryImpl
    private val remote: RawgDataSourceImpl = mock()
    private val local: RawgLocalDataSourceImpl = mock()
    private val result: DataResource<List<GameItemEntities>> = mock()

    @Before
    fun setUp(){
        repository = GamesRepositoryImpl(remote, local)
    }

    @Test
    fun `get game list data`(): Unit = runBlocking {
        val gameList = repository.fetchGameList(swipe = true, network = true)
        flow {
            Assert.assertNotNull(
                emit(gameList)
            )
        }
    }
}
