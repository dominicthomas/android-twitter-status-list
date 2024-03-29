package com.dogoodapps.statuslist.presentation.ui.main.models

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dogoodapps.domain.framework.Resource
import com.dogoodapps.domain.models.TweetDomainModel
import com.dogoodapps.domain.usecases.GetTweetsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TweetListViewModel @Inject constructor(
    private val getTweetsUseCase: GetTweetsUseCase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val tweetData = MutableLiveData<Resource<List<TweetDomainModel>>>()

    init {
        tweetData.value = Resource.success(emptyList())
    }

    fun getStatusList(): MutableLiveData<Resource<List<TweetDomainModel>>> {
        return tweetData
    }

    @SuppressLint("CheckResult")
    fun loadStatusList(listId: String) {
        tweetData.value = Resource.loading(emptyList())
        compositeDisposable.add(
            getTweetsUseCase.getStatusList(getTweetsUseCase.buildRequest(listId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onStatusListReceived, this::onError)
        )
    }

    private fun onStatusListReceived(tweetList: List<TweetDomainModel>) {
        tweetData.value = Resource.success(tweetList)
    }

    private fun onError(error: Throwable) {
        tweetData.value = Resource.error(error.localizedMessage, emptyList())
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}