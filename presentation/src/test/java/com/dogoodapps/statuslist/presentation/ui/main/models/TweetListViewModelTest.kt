package com.dogoodapps.statuslist.presentation.ui.main.models

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.dogoodapps.statuslist.TestSchedulersRule
import com.dogoodapps.data.model.TweetDataModel
import com.dogoodapps.data.model.TweetMapper
import com.dogoodapps.data.networking.requests.TweetRequest
import com.dogoodapps.domain.entities.Tweet
import com.dogoodapps.domain.framework.Resource
import com.dogoodapps.domain.usecases.GetTweetsUseCase
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class TweetListViewModelTest {

    @Rule
    @JvmField
    var testSchedulerRule = TestSchedulersRule()

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var getTweetsUseCase: GetTweetsUseCase

    @Mock
    private lateinit var tweetMapper: TweetMapper

    @Mock
    private lateinit var fakeTweet: Tweet

    @Mock
    private lateinit var fakeTweetDataModel: TweetDataModel

    @Mock
    private lateinit var observer: Observer<Resource<List<TweetDataModel>>>

    private lateinit var tweetListViewModel: TweetListViewModel

    private val fakeListId = "FAKE_LIST_ID"

    private val fakeErrorMessage = "ERROR_MESSAGE"

    private val fakeRequest = TweetRequest(fakeListId, "extended", "1", "10")

    @Before
    fun setup() {
        tweetListViewModel = TweetListViewModel(getTweetsUseCase, tweetMapper)
        val buildParams = fakeRequest.buildParams()
        `when`(getTweetsUseCase.buildRequest(fakeListId)).thenReturn(buildParams)
        `when`(getTweetsUseCase.getStatusList(buildParams)).thenReturn(Single.just(listOf(fakeTweet)))
        `when`(tweetMapper.convert(fakeTweet)).thenReturn(fakeTweetDataModel)
        tweetListViewModel.getStatusList().observeForever(observer)
    }

    @Test
    fun loadStatusList_setsResourceToLoadingState() {
        tweetListViewModel.loadStatusList(fakeListId)
        verify(observer).onChanged(Resource.loading(emptyList()))
    }

    @Test
    fun loadStatusList_withId_returnsAndMapsEntityToModel() {
        tweetListViewModel.loadStatusList(fakeListId)
        verify(observer).onChanged(Resource.loading(emptyList()))
        verify(observer).onChanged(Resource.success(listOf(fakeTweetDataModel)))
    }

    @Test
    fun loadStatusList_whenThereIsAnError_returnsResourceWithError() {
        `when`(getTweetsUseCase.getStatusList(fakeRequest.buildParams()))
            .thenReturn(Single.error(Throwable(fakeErrorMessage)))
        tweetListViewModel.loadStatusList(fakeListId)
        verify(observer).onChanged(Resource.loading(emptyList()))
        verify(observer).onChanged(Resource.error(fakeErrorMessage, emptyList()))
    }
}