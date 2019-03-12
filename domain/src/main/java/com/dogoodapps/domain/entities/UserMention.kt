package com.dogoodapps.domain.entities

data class UserMention(
    val id: Int,
    val id_str: String,
    val indices: List<Int>,
    val name: String,
    val screen_name: String
)