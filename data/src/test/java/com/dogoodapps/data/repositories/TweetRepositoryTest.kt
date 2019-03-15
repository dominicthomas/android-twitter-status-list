package com.dogoodapps.data.repositories

import com.dogoodapps.data.networking.TwitterService
import com.dogoodapps.data.networking.requests.TweetRequest
import com.dogoodapps.domain.entities.Status
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
    private lateinit var mockStatus: Status

    @Mock
    private lateinit var mockTwitterService: TwitterService

    private val tweetRequest = TweetRequest("list_id", "extended", "1", "10")

    @Before
    fun setup() {
        Mockito.`when`(mockTwitterService.getStatusList(fakeAuthToken, tweetRequest.buildParams()))
            .thenReturn(Single.just(listOf(mockStatus)))
    }

    @Test
    fun getTweets_withRequestParams_callsGetStatusListOnTweetService() {
        val tweetRepository = TweetRepositoryImpl(mockTwitterService)
        val tweetParams = tweetRequest.buildParams()
        tweetRepository.getStatusList(fakeAuthToken, tweetParams)
        verify(mockTwitterService).getStatusList(fakeAuthToken, tweetParams)
    }
}