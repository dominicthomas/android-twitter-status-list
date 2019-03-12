package com.dogoodapps.domain.entities

data class RetweetedStatus(
    val contributors: Any,
    val coordinates: Any,
    val created_at: String,
    val display_text_range: List<Int>,
    val entities: EntitiesX,
    val extended_entities: ExtendedEntities,
    val favorite_count: Int,
    val favorited: Boolean,
    val full_text: String,
    val geo: Any,
    val id: Long,
    val id_str: String,
    val in_reply_to_screen_name: Any,
    val in_reply_to_status_id: Any,
    val in_reply_to_status_id_str: Any,
    val in_reply_to_user_id: Any,
    val in_reply_to_user_id_str: Any,
    val is_quote_status: Boolean,
    val lang: String,
    val place: Any,
    val possibly_sensitive: Boolean,
    val retweet_count: Int,
    val retweeted: Boolean,
    val source: String,
    val truncated: Boolean,
    val user: UserX
)