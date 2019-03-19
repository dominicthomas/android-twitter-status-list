package com.dogoodapps.domain.models

data class TweetDomainModel(
    val id: Long,
    val created_at: String,
    val full_text: String,
    val profile_image_url: String
)