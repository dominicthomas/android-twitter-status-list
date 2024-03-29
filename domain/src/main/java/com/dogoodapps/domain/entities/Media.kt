package com.dogoodapps.domain.entities

data class Media(
    val display_url: String,
    val expanded_url: String,
    val id: Long,
    val id_str: String,
    val indices: List<Int>,
    val media_url: String,
    val media_url_https: String,
    val sizes: Sizes,
    val type: String,
    val url: String
)