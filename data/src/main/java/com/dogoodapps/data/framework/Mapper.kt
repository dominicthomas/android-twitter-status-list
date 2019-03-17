package com.dogoodapps.data.framework

interface Mapper<IN, OUT> {
    fun convert(from: IN): OUT
}