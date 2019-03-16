package com.dogoodapps.chirp.presentation.ui.main.models

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.dogoodapps.chirp.TestSchedulersRule
import com.dogoodapps.data.model.TweetDataModel
import com.dogoodapps.data.model.TweetMapper
import com.dogoodapps.domain.framework.Resource
import com.dogoodapps.domain.usecases.GetTweetsUseCase
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
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
    private lateinit var observer: Observer<Resource<List<TweetDataModel>>>

    private lateinit var tweetListViewModel: TweetListViewModel

    //     @get:Rule
    //    val taskExecutorRule = InstantTaskExecutorRule() ??

    // Test: Resource loading - assert live data values
    // assert(bufferoosViewModel.getBufferoos().value.status ==
    //        ResourceState.LOADING)
    //

    // verify(observer).onChanged(
    //        Resource(ResourceState.SUCCESS, bufferoos))
    // assert(bufferoosViewModel.getBufferoos().value.status ==
    //        ResourceState.SUCCESS)

    // See: https://medium.com/@marco_cattaneo/unit-testing-with-mockito-on-kotlin-android-project-with-architecture-components-2059eb637912

    // See; https://medium.com/@nicolas.duponchel/testing-viewmodel-in-mvvm-using-livedata-and-rxjava-b27878495220

    @Before
    fun setup() {
        tweetListViewModel = TweetListViewModel(getTweetsUseCase, tweetMapper)
    }

    @Test
    fun firstTest() {
        assertNotNull(tweetListViewModel)
    }

}