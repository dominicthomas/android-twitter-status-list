package com.dogoodapps.chirp.presentation.ui.main.models

import com.dogoodapps.domain.entities.Tweet


fun Tweet.toTweetViewModel() = TweetViewModel(
    id = id,
    created_at = created_at,
    full_text = full_text
)
