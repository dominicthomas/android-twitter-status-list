package com.dogoodapps.chirp.presentation.ui.main.models

data class TweetViewModel(
    val id: Long,
    val created_at: String,
    val full_text: String
)