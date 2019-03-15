package com.dogoodapps.data.usecases

import com.dogoodapps.data.networking.requests.TweetRequest
import com.dogoodapps.domain.auth.AuthService
import com.dogoodapps.domain.entities.Status
import com.dogoodapps.domain.repositories.TweetRepository
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GetTweetsUseCaseTest {

    private val fakeListId = "LIST_ID"
    private val fakeAuthToken = "AUTH_TOKEN"

    @Mock
    private lateinit var mockStatus: Status

    @Mock
    private lateinit var mockTweetRepository: TweetRepository

    @Mock
    private lateinit var mockAuthService: AuthService

    private val tweetRequest = TweetRequest(fakeListId, "extended", "1", "10")

    @Before
    fun setup() {
        `when`(mockTweetRepository.getStatusList(fakeAuthToken, tweetRequest.buildParams()))
            .thenReturn(Single.just(listOf(mockStatus)))
        `when`(mockAuthService.getToken()).thenReturn(fakeAuthToken)
    }

    @Test
    fun getTweets_withRequestParams_callsGetTweetsOnRepository() {
        val getTweetsUseCase = GetTweetsUseCaseImpl(mockTweetRepository, mockAuthService)
        val tweetParams = tweetRequest.buildParams()
        val tweets = getTweetsUseCase.getStatusList(tweetParams)
        verify(mockTweetRepository).getStatusList(fakeAuthToken, tweetParams)
        assertNotNull(tweets)
    }

    @Test
    fun buildRequest_withListId_returnsExpectedParams() {
        val getTweetsUseCase = GetTweetsUseCaseImpl(mockTweetRepository, mockAuthService)
        val buildRequest = getTweetsUseCase.buildRequest(fakeListId)
        assertEquals(tweetRequest.listId, buildRequest["list_id"])
    }
}