package com.dogoodapps.domain.entities

data class EntitiesX(
    val hashtags: List<Hashtag>,
    val media: List<Media>,
    val symbols: List<Any>,
    val urls: List<Url>,
    val user_mentions: List<Any>
)