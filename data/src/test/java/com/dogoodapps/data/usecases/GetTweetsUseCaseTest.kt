package com.dogoodapps.data.usecases

import com.dogoodapps.data.model.TweetMapper
import com.dogoodapps.data.networking.requests.TweetRequest
import com.dogoodapps.domain.auth.AuthService
import com.dogoodapps.domain.entities.Tweet
import com.dogoodapps.domain.models.TweetDomainModel
import com.dogoodapps.domain.repositories.TweetRepository
import io.reactivex.Single
import org.junit.Assert.*
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
    private lateinit var mockTweet: Tweet

    @Mock
    private lateinit var mockTweetRepository: TweetRepository

    @Mock
    private lateinit var mockAuthService: AuthService

    @Mock
    private lateinit var mockTweetMapper: TweetMapper

    @Mock
    private lateinit var mockTweetDomainModel: TweetDomainModel

    private val tweetRequest = TweetRequest(fakeListId, "extended", "1", "10")

    @Before
    fun setup() {
        `when`(mockTweetRepository.getStatusList(fakeAuthToken, tweetRequest.buildParams()))
            .thenReturn(Single.just(listOf(mockTweet)))
        `when`(mockAuthService.getToken()).thenReturn(fakeAuthToken)
        `when`(mockTweetMapper.convert(mockTweet)).thenReturn(mockTweetDomainModel)
    }

    @Test
    fun getTweets_withRequestParams_callsGetTweetsOnRepository() {
        val getTweetsUseCase = GetTweetsUseCaseImpl(mockTweetRepository, mockAuthService, mockTweetMapper)
        val tweetParams = tweetRequest.buildParams()
        val tweets = getTweetsUseCase.getStatusList(tweetParams)
        verify(mockTweetRepository).getStatusList(fakeAuthToken, tweetParams)
        assertNotNull(tweets)
    }

    @Test
    fun getTweets_withRequestParams_returnsListOfTweetDomainModel() {
        val getTweetsUseCase = GetTweetsUseCaseImpl(mockTweetRepository, mockAuthService, mockTweetMapper)
        val tweetParams = tweetRequest.buildParams()
        val tweets = getTweetsUseCase.getStatusList(tweetParams).blockingGet()
        assertTrue(tweets.size == 1)
        assertTrue(tweets.contains(mockTweetDomainModel))
    }

    @Test
    fun buildRequest_withListId_returnsExpectedParams() {
        val getTweetsUseCase = GetTweetsUseCaseImpl(mockTweetRepository, mockAuthService, mockTweetMapper)
        val buildRequest = getTweetsUseCase.buildRequest(fakeListId)
        assertEquals(tweetRequest.listId, buildRequest["list_id"])
    }
}