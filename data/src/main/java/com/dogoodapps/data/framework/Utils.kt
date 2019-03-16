package com.dogoodapps.data.framework

import java.text.SimpleDateFormat
import java.util.*

fun String.twitterFriendlyDate(): String? {
    val dateFormat = SimpleDateFormat(
        "EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH
    )
    dateFormat.isLenient = false
    val created = dateFormat.parse(this)

    val anotherDateFormat = SimpleDateFormat(
        "MMM dd yyyy HH:mm", Locale.ENGLISH
    )

    return anotherDateFormat.format(created)
}