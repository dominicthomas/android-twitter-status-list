package com.dogoodapps.domain.repositories

import com.dogoodapps.domain.entities.Tweet
import io.reactivex.Single

interface TweetRepository {
    fun getStatusList(): Single<List<Tweet>>
}