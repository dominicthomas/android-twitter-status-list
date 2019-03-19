package com.dogoodapps.data.usecases

import com.dogoodapps.data.model.TweetMapper
import com.dogoodapps.data.networking.requests.TweetRequest
import com.dogoodapps.domain.auth.AuthService
import com.dogoodapps.domain.models.TweetDomainModel
import com.dogoodapps.domain.repositories.TweetRepository
import com.dogoodapps.domain.usecases.GetTweetsUseCase
import io.reactivex.Single
import javax.inject.Inject

open class GetTweetsUseCaseImpl @Inject constructor(
    private val tweetRepository: TweetRepository,
    private val authService: AuthService,
    private val tweetMapper: TweetMapper
) : GetTweetsUseCase {

    override fun getStatusList(params: Map<String, String>): Single<List<TweetDomainModel>> {
        return tweetRepository.getStatusList(authService.getToken(), params)
            .map { item -> item.map { tweetMapper.convert(it) } }
    }

    override fun buildRequest(listId: String): Map<String, String> {
        return TweetRequest(listId, "extended", "1", "10").buildParams()
    }
}