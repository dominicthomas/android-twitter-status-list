package com.dogoodapps.data.networking.requests

data class TweetRequest(
    val listId: String,
    val tweetMode: String,
    val includeEntities: String,
    val count: String
) {

    fun buildParams(): Map<String, String> {
        return hashMapOf(
            "list_id" to listId,
            "tweet_mode" to tweetMode,
            "include_entities" to includeEntities,
            "count" to count
        )
    }
}


