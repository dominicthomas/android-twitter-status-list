package com.dogoodapps.domain.entities

data class Url(
    val display_url: String,
    val expanded_url: String,
    val indices: List<Int>,
    val url: String
)