package com.ruangaldo.ruanggame.domain.model

import android.graphics.Bitmap
import com.ruangaldo.ruanggame.data.local.entity.GenreEntity
import com.ruangaldo.ruanggame.data.local.entity.PlatformEntity
import com.ruangaldo.ruanggame.data.remote.dto.Genre
import com.ruangaldo.ruanggame.data.remote.dto.ParentPlatform
import com.ruangaldo.ruanggame.data.remote.dto.Platforms

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

data class GameUiItemModel(
    val image: String? = null,
    val title: String? = "",
    val platform: List<PlatformEntity>? = emptyList(),
    val release: String? = "",
    val genres: List<GenreEntity>? = emptyList()
)
