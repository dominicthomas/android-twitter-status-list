package com.dogoodapps.domain.entities

data class Tweet(
    val created_at: String,
    val entities: Entities,
    val extended_entities: ExtendedEntities,
    val favorite_count: Int,
    val favorited: Boolean,
    val full_text: String,
    val id: Long,
    val id_str: String,
    val is_quote_status: Boolean,
    val lang: String,
    val retweet_count: Int,
    val retweeted: Boolean,
    val source: String,
    val user: User
)