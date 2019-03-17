package com.dogoodapps.data.model

data class TweetDataModel(
    val id: Long,
    val created_at: String,
    val full_text: String,
    val profile_image_url: String
)