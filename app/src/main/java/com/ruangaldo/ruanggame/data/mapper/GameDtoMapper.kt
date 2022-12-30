package com.ruangaldo.ruanggame.data.mapper

import com.ruangaldo.ruanggame.data.local.entity.GameItemEntities
import com.ruangaldo.ruanggame.data.local.entity.GenreEntity
import com.ruangaldo.ruanggame.data.local.entity.PlatformEntity
import com.ruangaldo.ruanggame.data.remote.dto.GetGameListDto

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

object GameDtoMapper {
    fun toGameListEntities(data: GetGameListDto): List<GameItemEntities> {
        val temp: MutableList<GameItemEntities> = mutableListOf()
        data.results?.forEach { result ->
            temp.add(
                GameItemEntities(
                    id = result.id ?: 0,
                    image = result.background_image ?: "",
                    release = result.released ?: "",
                    title = result.name ?: "",
                    genres = result.genres?.map {
                        GenreEntity(it.id, it.name, it.slug, it.image_background)
                    },
                    platform = result.parent_platforms.map {
                        PlatformEntity(it.platform?.id, it.platform?.name, it.platform?.slug)
                    }
                )
            )
        }
        return temp
    }

}

