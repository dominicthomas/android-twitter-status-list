package com.dogoodapps.chirp.presentation.ui.models

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dogoodapps.domain.entities.Tweet
import com.dogoodapps.domain.framework.Resource
import com.dogoodapps.domain.usecases.GetTweetsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StatusViewModel @Inject constructor(private val getTweetsUseCase: GetTweetsUseCase) : ViewModel() {

    private val statusListLiveData = MutableLiveData<Resource<List<Tweet>>>()

    private val compositeDisposable = CompositeDisposable()

    init {
        statusListLiveData.value = Resource.success(emptyList())
    }

    fun getStatusList(listId: String): MutableLiveData<Resource<List<Tweet>>> {
        loadStatusList(listId)
        return statusListLiveData
    }

    @SuppressLint("CheckResult")
    private fun loadStatusList(listId: String) {
        statusListLiveData.value = Resource.loading(emptyList())
        compositeDisposable.add(
            getTweetsUseCase.getTweets(listId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onStatusListReceived, this::onError)
        )
    }

    private fun onStatusListReceived(statusList: List<Tweet>) {
        statusListLiveData.value = Resource.success(statusList)
    }

    private fun onError(error: Throwable) {
        statusListLiveData.value = Resource.error(error.localizedMessage, emptyList())
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}