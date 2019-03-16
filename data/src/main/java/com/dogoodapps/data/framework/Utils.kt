package com.dogoodapps.data.framework

import java.text.SimpleDateFormat
import java.util.*

fun String.twitterFriendlyDate(): String? {
    val apiDateFormat = SimpleDateFormat(
        "EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH
    )
    apiDateFormat.isLenient = false
    val createdAt = apiDateFormat.parse(this)

    val simpleDateFormat = SimpleDateFormat(
        "MMM dd yyyy HH:mm", Locale.ENGLISH
    )

    return simpleDateFormat.format(createdAt)
}
