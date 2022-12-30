package com.ruangaldo.ruanggame.domain

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.ruangaldo.ruanggame.data.repository.GamesRepositoryImpl
import com.ruangaldo.ruanggame.domain.model.GameUiListModel
import com.ruangaldo.ruanggame.domain.repository.IGamesRepository
import com.ruangaldo.ruanggame.domain.usecase.FetchGameListUseCase
import com.ruangaldo.ruanggame.util.wrapper.ViewResource
import junit.framework.TestCase
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * Written with joy and smile by Ruang Aldo on 30/12/22.
 * Github: https://github.com/reinaldoriant
 */

class GameListDomainTest {
    private lateinit var useCase: FetchGameListUseCase

    private val repository: IGamesRepository = mock()
    private val result: ViewResource<GameUiListModel> = mock()

    @Before
    fun setUp() {
        useCase = FetchGameListUseCase(repository)
    }

    @Test
    fun `Should get weather from repository`(): Unit = runBlocking {
        val input = useCase.invoke()
        flow {
            emit(ViewResource.Loading())
            input.collect{ response ->
                TestCase.assertNotNull(
                    emit(ViewResource.Success(response.payload))
                )
                TestCase.assertEquals(
                    emit(ViewResource.Success(result.payload)),
                    emit(ViewResource.Success(response.payload))
                )
            }
        }
        verifyNoMoreInteractions(repository)
    }
}
