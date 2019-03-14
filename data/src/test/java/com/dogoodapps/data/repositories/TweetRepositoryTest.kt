package com.dogoodapps.data.repositories

import com.dogoodapps.data.networking.TweetService
import com.dogoodapps.data.networking.requests.TweetRequest
import com.dogoodapps.domain.entities.Tweet
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TweetRepositoryTest {

    private val fakeAuthToken = "AUTH_TOKEN"

    @Mock
    private lateinit var mockTweet: Tweet

    @Mock
    private lateinit var mockTweetService: TweetService

    private val tweetRequest = TweetRequest("list_id", "extended", "1", "10")

    @Before
    fun setup() {
        Mockito.`when`(mockTweetService.getStatusList(fakeAuthToken, tweetRequest.buildParams()))
            .thenReturn(Single.just(listOf(mockTweet)))
    }

    @Test
    fun getTweets_withRequestParams_callsGetStatusListOnTweetService() {
        val tweetRepository = TweetRepositoryImpl(mockTweetService)
        val tweetParams = tweetRequest.buildParams()
        tweetRepository.getTweets(fakeAuthToken, tweetParams)
        verify(mockTweetService).getStatusList(fakeAuthToken, tweetParams)
    }
}