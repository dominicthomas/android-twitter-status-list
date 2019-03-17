package com.dogoodapps.data.model

import android.os.Build
import android.text.Html
import com.dogoodapps.data.framework.Mapper
import com.dogoodapps.domain.entities.Tweet
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


open class TweetMapper @Inject constructor() : Mapper<Tweet, TweetDataModel> {
    override fun convert(from: Tweet): TweetDataModel {
        return from.toTweetViewModel()
    }
}

fun Tweet.toTweetViewModel() = TweetDataModel(
    id = id,
    created_at = created_at.parseDate().formatDate(),
    full_text = full_text.fromHtml()
)

fun String.parseDate(): Date {
    val apiDateFormat = SimpleDateFormat(
        "EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH
    )
    apiDateFormat.isLenient = false
    return apiDateFormat.parse(this)
}

fun Date.formatDate(): String {
    val simpleDateFormat = SimpleDateFormat(
        "dd MMM yyyy - HH:mm", Locale.ENGLISH
    )

    return simpleDateFormat.format(this)
}

fun String.fromHtml(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString()
    } else {
        Html.fromHtml(this).toString()
    }
}