package com.dogoodapps.data.usecases

import com.dogoodapps.domain.auth.AuthService
import com.dogoodapps.domain.entities.Tweet
import com.dogoodapps.domain.repositories.TweetRepository
import com.dogoodapps.domain.usecases.GetTweetsUseCase
import io.reactivex.Single
import javax.inject.Inject

open class GetTweetsUseCaseImpl @Inject constructor(
    private val tweetRepository: TweetRepository,
    private val authService: AuthService
) : GetTweetsUseCase {

    override fun getTweets(listId: String): Single<List<Tweet>> {

        // This are dummy params for the sake of the demo.. would be built dynamically in a real app
        val queryParams = hashMapOf(
            "list_id" to listId,
            "tweet_mode" to "extended",
            "include_entities" to 1.toString(),
            "count" to 10.toString()
        )

        return tweetRepository.getStatusList(authService.getToken(), queryParams)
    }
}