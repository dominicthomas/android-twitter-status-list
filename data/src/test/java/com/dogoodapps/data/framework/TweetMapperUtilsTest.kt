package com.dogoodapps.data.framework

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class TweetMapperUtilsTest {

    @Mock
    private lateinit var fakeHtmlParser: HtmlParser

    private val fakeString = "FAKE_STRING"

    private val fakeCreatedAt = "Sat Mar 16 14:08:01 +0000 2019"

    private val createAtResult = "16 Mar 2019 @ 14:08"

    private lateinit var tweetMapperUtils: TweetMapperUtils

    @Before
    fun setup() {
        `when`(fakeHtmlParser.parse(anyString())).thenReturn(fakeString)
        tweetMapperUtils = TweetMapperUtils(fakeHtmlParser)
    }

    @Test
    fun parseDate_withFakeCreatedAt_returnsCorrectDateObject() {
        val parseDate = tweetMapperUtils.parseDate(fakeCreatedAt)
        val instance = Calendar.getInstance()
        instance.time = parseDate
        assertEquals(7, instance.get(Calendar.DAY_OF_WEEK))
        assertEquals(2, instance.get(Calendar.MONTH))
        assertEquals(16, instance.get(Calendar.DATE))
        assertEquals(2019, instance.get(Calendar.YEAR))
        assertEquals(14, instance.get(Calendar.HOUR_OF_DAY))
        assertEquals(8, instance.get(Calendar.MINUTE))
        assertEquals(1, instance.get(Calendar.SECOND))
        assertEquals(0, instance.get(Calendar.ZONE_OFFSET))
    }

    @Test
    fun formatDate_withDateObject_formatsToSpecifiedFormat() {
        val parseDate = tweetMapperUtils.parseDate(fakeCreatedAt)
        val formatDate = tweetMapperUtils.formatDate(parseDate)
        assertEquals(createAtResult, formatDate)
    }

    @Test
    fun fromHtml_callsParseOnHtmlParser() {
        tweetMapperUtils.fromHtml(fakeString)
        verify(fakeHtmlParser).parse(fakeString)
    }
}