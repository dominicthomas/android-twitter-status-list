package com.dogoodapps.data.networking


import com.dogoodapps.domain.entities.Status
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.QueryMap

interface TwitterService {

    @GET("lists/statuses.json")
    fun getStatusList(
        @Header("Authorization") token: String?,
        @QueryMap params: Map<String, String>
    ): Single<List<Status>>
}