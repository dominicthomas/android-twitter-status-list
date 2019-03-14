package com.dogoodapps.data.networking.requests

import org.junit.Test

class TweetRequestTest {

    private val listId = "LIST_ID"
    private val tweetMode = "TWEET_MODE"
    private val includeEntities = "INCLUDED_ENTITIES"
    private val count = "COUNT"

    private val mockTweetRequest = TweetRequest(listId, tweetMode, includeEntities, count)

    @Test
    fun buildParams_forMockRequest_returnsRequiredMap() {
        val buildParams = mockTweetRequest.buildParams()
        assert(buildParams.containsKey("list_id"))
        assert(buildParams.containsKey("tweet_mode"))
        assert(buildParams.containsKey("include_entities"))
        assert(buildParams.containsKey("count"))

        assert(buildParams["list_id"].equals(listId))
        assert(buildParams["tweet_mode"].equals(tweetMode))
        assert(buildParams["include_entities"].equals(includeEntities))
        assert(buildParams["count"].equals(count))
    }
}