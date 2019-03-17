package com.dogoodapps.data.model

import com.dogoodapps.data.framework.Mapper
import com.dogoodapps.data.framework.TweetMapperUtils
import com.dogoodapps.domain.entities.Tweet
import javax.inject.Inject


open class TweetMapper @Inject constructor(
    private val tweetMapperUtils: TweetMapperUtils
) : Mapper<Tweet, TweetDataModel> {

    override fun convert(from: Tweet): TweetDataModel {
        return from.toTweetViewModel(tweetMapperUtils)
    }
}

fun Tweet.toTweetViewModel(tweetMapperUtils: TweetMapperUtils) = TweetDataModel(
    id = id,
    created_at = tweetMapperUtils.formatDate(tweetMapperUtils.parseDate(created_at)),
    full_text = tweetMapperUtils.fromHtml(full_text),
    profile_image_url = user.profile_image_url_https
)
