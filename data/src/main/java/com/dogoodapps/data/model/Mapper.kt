package com.dogoodapps.data.model

interface Mapper<IN, OUT> {
    fun convert(from: IN): OUT
}