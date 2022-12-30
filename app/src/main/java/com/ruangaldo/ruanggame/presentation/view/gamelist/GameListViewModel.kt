package com.ruangaldo.ruanggame.presentation.view.gamelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruangaldo.ruanggame.domain.model.GameUiListModel
import com.ruangaldo.ruanggame.domain.usecase.FetchGameListUseCase
import com.ruangaldo.ruanggame.util.wrapper.ViewResource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

@HiltViewModel
class GameListViewModel @Inject constructor(private val useCase: FetchGameListUseCase) :
    ViewModel() {

    val gameListResult = MutableLiveData<ViewResource<GameUiListModel?>>()

    fun fetchGame() {
        viewModelScope.launch {
            useCase().collect{
                gameListResult.postValue(it)
            }
        }
    }
}
