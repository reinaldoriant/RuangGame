package com.ruangaldo.ruanggame.presentation

import com.nhaarman.mockitokotlin2.mock
import com.ruangaldo.ruanggame.domain.model.GameUiListModel
import com.ruangaldo.ruanggame.domain.usecase.FetchGameListUseCase
import com.ruangaldo.ruanggame.domain.usecase.GameListUseCase
import com.ruangaldo.ruanggame.presentation.view.gamelist.GameListViewModel
import com.ruangaldo.ruanggame.util.BaseUnitTest
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Written with joy and smile by Ruang Aldo on 30/12/22.
 * Github: https://github.com/reinaldoriant
 */

@OptIn(ExperimentalCoroutinesApi::class)
class GameListViewModelTest : BaseUnitTest(){
    private lateinit var useCase: GameListUseCase
    private var fetchUseCase: FetchGameListUseCase = mock()
    private lateinit var viewModel: GameListViewModel

    private val article: GameUiListModel = mock()


    @Before
    fun setUp() {
        useCase = GameListUseCase(fetchUseCase)
        viewModel = GameListViewModel(useCase)
    }

    @Test
    fun `success get game list`() = runTest {
        viewModel.fetchGame()
        flow {
            emit(viewModel.fetchGame())
            assertNotNull(viewModel.gameListResult.value)
            assertEquals(article, viewModel.gameListResult.value?.payload)
        }
    }
}
