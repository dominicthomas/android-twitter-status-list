package com.dogoodapps.chirp.data.networking

import com.dogoodapps.chirp.domain.entities.Tweet
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.QueryMap

interface TweetService {

    @GET("lists/statuses.json")
    fun getStatusList(
        @Header("Authorization") token: String?,
        @QueryMap params: Map<String, String>
    ): Single<List<Tweet>>
}