package com.dogoodapps.data.usecases

import com.dogoodapps.domain.entities.Tweet
import com.dogoodapps.domain.repositories.TweetRepository
import com.dogoodapps.domain.usecases.GetTweetsUseCase
import io.reactivex.Single
import javax.inject.Inject

open class GetTweetsUseCaseImpl @Inject constructor(private val tweetRepository: TweetRepository) :
    GetTweetsUseCase {

    override fun getTweets(): Single<List<Tweet>> {
        return tweetRepository.getStatusList()
    }
}