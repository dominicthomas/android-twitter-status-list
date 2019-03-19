package com.dogoodapps.domain.usecases

import com.dogoodapps.domain.models.TweetDomainModel
import io.reactivex.Single

interface GetTweetsUseCase {
    fun getStatusList(params: Map<String, String>): Single<List<TweetDomainModel>>

    fun buildRequest(listId: String): Map<String, String>
}