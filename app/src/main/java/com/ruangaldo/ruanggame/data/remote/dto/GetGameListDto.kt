package com.ruangaldo.ruanggame.data.remote.dto

data class GetGameListDto(
    val count: Int? = 0,
    val next: String? = "",
    val previous: String? = "",
    val results: List<Results>? = emptyList()
)

data class Results(
    val id: Int? = 0,
    val slug: String? = "",
    val name: String? = "",
    val released: String? = "",
    val tba: Boolean? = false,
    val background_image: String? = "",
    val rating: Double? = 0.0,
    val rating_top: Int? = 0,
    val ratings: Any? = null,
    val ratings_count: Int? = 0,
    val reviews_text_count: String? = "",
    val added: Int? = 0,
    val added_by_status: Any? = null,
    val metacritic: Int = 0,
    val playtime: Int = 0,
    val suggestions_count: Int = 0,
    val updated: String? = "",
    val esrb_rating: EsrbRating? = null,
    val platforms: List<Platforms>? = emptyList(),
    val parent_platforms: List<ParentPlatform> = emptyList(),
    val genres: List<Genre>? = emptyList(),
    val tags: List<Tag>? = emptyList()
)

data class EsrbRating(
    val id: Int? = 0,
    val slug: String? = "",
    val name: String? = ""
)

data class Platforms(
    val platform: Platform? = null,
    val released_at: String? = "",
    val requirements: Requirements? = null
)

data class Platform(
    val id: Int? = 0,
    val slug: String? = "",
    val name: String? = ""
)

data class ParentPlatform(
    val platform: Platform? = null
)

data class Requirements(
    val minimum: String? = "",
    val recommended: String? = ""
)

data class Genre(
    val id: Int? = 0,
    val name: String? = "",
    val slug: String? = "",
    val image_background: String? = ""
)

data class Tag(
    val id: Int? = 0,
    val name: String? = "",
    val slug: String? = "",
    val language: String? = "",
    val games_count: Int? = 0,
    val image_background: String? = ""
)
