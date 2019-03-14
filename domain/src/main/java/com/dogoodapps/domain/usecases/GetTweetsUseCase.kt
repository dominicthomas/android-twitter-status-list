package com.dogoodapps.domain.usecases

import com.dogoodapps.domain.entities.Tweet
import io.reactivex.Single

interface GetTweetsUseCase {
    fun getTweets(params: Map<String, String>): Single<List<Tweet>>

    fun buildRequest(listId: String): Map<String, String>
}