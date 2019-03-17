package com.dogoodapps.data.framework

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class TweetMapperUtils @Inject constructor(private val htmlParser: HtmlParser) {

    private val twitterDatePattern = "EEE MMM dd HH:mm:ss ZZZZZ yyyy"

    private val applicationDatePattern = "dd MMM yyyy - HH:mm"

    fun parseDate(dateString: String): Date {
        val apiDateFormat = SimpleDateFormat(twitterDatePattern, Locale.ENGLISH)
        apiDateFormat.isLenient = false
        return apiDateFormat.parse(dateString)
    }

    fun formatDate(date: Date): String {
        val simpleDateFormat = SimpleDateFormat(applicationDatePattern, Locale.ENGLISH)
        return simpleDateFormat.format(date)
    }

    fun fromHtml(htmlString: String): String {
        return htmlParser.parse(htmlString)
    }
}