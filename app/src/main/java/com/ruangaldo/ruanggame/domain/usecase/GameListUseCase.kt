package com.ruangaldo.ruanggame.domain.usecase

import javax.inject.Inject

/**
 * Written with joy and smile by Ruang Aldo on 30/12/22.
 * Github: https://github.com/reinaldoriant
 */

data class GameListUseCase @Inject constructor(
    val fetch: FetchGameListUseCase,
)
