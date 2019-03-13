package com.dogoodapps.data.networking

import com.dogoodapps.domain.entities.Tweet
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface TweetService {

    @GET("lists/statuses.json")
    fun getStatusList(@QueryMap params: Map<String, Any>): Single<List<Tweet>>

}