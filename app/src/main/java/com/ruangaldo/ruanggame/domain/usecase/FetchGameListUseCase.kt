package com.ruangaldo.ruanggame.domain.usecase

import com.ruangaldo.ruanggame.domain.mapper.GameUiMapper
import com.ruangaldo.ruanggame.domain.model.GameUiListModel
import com.ruangaldo.ruanggame.domain.repository.IGamesRepository
import com.ruangaldo.ruanggame.util.extension.suspendSubscribe
import com.ruangaldo.ruanggame.util.wrapper.ViewResource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

class FetchGameListUseCase @Inject constructor(
    private val repository: IGamesRepository
) {
    operator fun invoke(swipe: Boolean, network: Boolean): Flow<ViewResource<GameUiListModel?>> = flow {
        emit(ViewResource.Loading())
        repository.fetchGameList(swipe, network).collect { response ->
            response.suspendSubscribe(
                doOnSuccess = {
                    emit(ViewResource.Success(GameUiMapper.toGameUiItem(it)))
                },
                doOnError = { error ->
                    emit(ViewResource.Error(exception = error.exception, msg = error.message))
                }
            )
        }
    }
}
