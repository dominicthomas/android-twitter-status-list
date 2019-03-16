package com.dogoodapps.data.model

import com.dogoodapps.domain.entities.Tweet
import javax.inject.Inject

open class TweetMapper @Inject constructor() : Mapper<Tweet, TweetDataModel> {
    override fun convert(from: Tweet): TweetDataModel {
        return from.toTweetViewModel()
    }
}

private fun Tweet.toTweetViewModel() = TweetDataModel(
    id = id,
    created_at = created_at,
    full_text = full_text
)
