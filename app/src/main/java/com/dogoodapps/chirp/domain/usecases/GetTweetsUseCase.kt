package com.dogoodapps.chirp.domain.usecases

import com.dogoodapps.chirp.domain.entities.Tweet
import io.reactivex.Single

interface GetTweetsUseCase {
    fun getTweets(listId: String): Single<List<Tweet>>
}