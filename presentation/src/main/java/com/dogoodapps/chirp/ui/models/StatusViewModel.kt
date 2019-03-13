package com.dogoodapps.chirp.ui.models

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dogoodapps.domain.entities.Tweet
import com.dogoodapps.domain.usecases.GetTweetsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StatusViewModel @Inject constructor(private val getTweetsUseCase: GetTweetsUseCase) : ViewModel() {

    // TODO: Use state object to represent error or success!!
    private val statusListLiveData = MutableLiveData<List<Tweet>>()

    private val compositeDisposable = CompositeDisposable()

    init {
        statusListLiveData.value = emptyList()
    }

    @SuppressLint("CheckResult")
    fun getStatusList() {
        compositeDisposable.add(
            getTweetsUseCase.getTweets()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onStatusListReceived, this::onError)
        )
    }

    private fun onStatusListReceived(statusList: List<Tweet>) {
        statusListLiveData.value = statusList
    }

    private fun onError(error: Throwable) {
        //statusListLiveData.value
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}