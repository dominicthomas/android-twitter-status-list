package com.dogoodapps.data.model

import com.dogoodapps.data.framework.HtmlParser
import com.dogoodapps.data.framework.TweetMapperUtils
import com.dogoodapps.domain.entities.Tweet
import com.dogoodapps.domain.entities.User
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TweetMapperTest {

    @Mock
    private lateinit var fakeTweet: Tweet

    @Mock
    private lateinit var fakeUser: User

    @Mock
    private lateinit var fakeParser: HtmlParser

    private val fakeId = 123456789L

    private val fakeCreatedAt = "Sat Mar 16 14:08:01 +0000 2019"

    private val fakeFullText = "Lorem ipsum etc etc etc"

    private val createAtResult = "16 Mar 2019 @ 14:08"

    private val fakeImageUrl = "IMAGE_URL"

    private val fakeTweetDataModel = TweetDataModel(fakeId, createAtResult, fakeFullText, fakeImageUrl)

    private lateinit var tweetMapper: TweetMapper

    @Before
    fun setup() {
        tweetMapper = TweetMapper((TweetMapperUtils(fakeParser)))
        `when`(fakeParser.parse(fakeFullText)).thenReturn(fakeFullText)
        `when`(fakeTweet.id).thenReturn(fakeId)
        `when`(fakeTweet.created_at).thenReturn(fakeCreatedAt)
        `when`(fakeTweet.full_text).thenReturn(fakeFullText)
        `when`(fakeUser.profile_image_url_https).thenReturn(fakeImageUrl)
        `when`(fakeTweet.user).thenReturn(fakeUser)
    }

    @Test
    fun convert_withFakeTweet_returnsTweetDataModel() {
        val tweetDataModel = tweetMapper.convert(fakeTweet)
        assertEquals(tweetDataModel, fakeTweetDataModel)
    }
}