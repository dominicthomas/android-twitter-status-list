package com.dogoodapps.domain.usecases

import com.dogoodapps.domain.entities.Status
import io.reactivex.Single

interface GetTweetsUseCase {
    fun getStatusList(params: Map<String, String>): Single<List<Status>>

    fun buildRequest(listId: String): Map<String, String>
}