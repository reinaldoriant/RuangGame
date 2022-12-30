package com.ruangaldo.ruanggame.domain.mapper

import com.ruangaldo.ruanggame.data.local.entity.GameItemEntities
import com.ruangaldo.ruanggame.data.remote.dto.GetGameListDto
import com.ruangaldo.ruanggame.domain.model.GameUiItemModel
import com.ruangaldo.ruanggame.domain.model.GameUiListModel
import com.ruangaldo.ruanggame.util.wrapper.DataResource

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

object GameUiMapper {
    fun toGameUiItem(
        response: DataResource<List<GameItemEntities>>
    ): GameUiListModel? = response.payload?.let { results ->
        GameUiListModel(
        list = results.map {
            GameUiItemModel(
                image = it.image,
                title = it.title,
                platform = it.platform,
                release = it.release,
                genres = it.genres
            )
        }
    )
    }
}
