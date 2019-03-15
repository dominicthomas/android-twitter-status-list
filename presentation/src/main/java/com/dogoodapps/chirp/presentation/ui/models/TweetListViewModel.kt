package com.dogoodapps.chirp.presentation.ui.models

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dogoodapps.domain.entities.Status
import com.dogoodapps.domain.framework.Resource
import com.dogoodapps.domain.usecases.GetTweetsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TweetListViewModel @Inject constructor(private val getTweetsUseCase: GetTweetsUseCase) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val statusData = MutableLiveData<Resource<List<Status>>>()

    init {
        statusData.value = Resource.success(emptyList())
    }

    fun getStatusList(): MutableLiveData<Resource<List<Status>>> {
        return statusData
    }

    @SuppressLint("CheckResult")
    fun loadStatusList(listId: String) {
        statusData.value = Resource.loading(emptyList())
        compositeDisposable.add(
            getTweetsUseCase.getStatusList(getTweetsUseCase.buildRequest(listId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onStatusListReceived, this::onError)
        )
    }

    private fun onStatusListReceived(statusList: List<Status>) {
        statusData.value = Resource.success(statusList)
    }

    private fun onError(error: Throwable) {
        statusData.value = Resource.error(error.localizedMessage, emptyList())
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}