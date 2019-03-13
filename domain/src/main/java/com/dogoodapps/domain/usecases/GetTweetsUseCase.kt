package com.dogoodapps.domain.usecases

import com.dogoodapps.domain.entities.Tweet
import io.reactivex.Single

interface GetTweetsUseCase {
    fun getTweets(listId: String): Single<List<Tweet>>
}