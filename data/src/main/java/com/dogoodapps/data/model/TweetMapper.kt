package com.dogoodapps.data.model

import com.dogoodapps.data.framework.Mapper
import com.dogoodapps.data.framework.TweetMapperUtils
import com.dogoodapps.domain.entities.Tweet
import com.dogoodapps.domain.models.TweetDomainModel
import javax.inject.Inject


open class TweetMapper @Inject constructor(
    private val tweetMapperUtils: TweetMapperUtils
) : Mapper<Tweet, TweetDomainModel> {

    override fun convert(from: Tweet): TweetDomainModel {
        return from.toTweetViewModel(tweetMapperUtils)
    }
}

fun Tweet.toTweetViewModel(tweetMapperUtils: TweetMapperUtils) = TweetDomainModel(
    id = id,
    created_at = tweetMapperUtils.formatDate(tweetMapperUtils.parseDate(created_at)),
    full_text = tweetMapperUtils.fromHtml(full_text),
    profile_image_url = user.profile_image_url_https
)
