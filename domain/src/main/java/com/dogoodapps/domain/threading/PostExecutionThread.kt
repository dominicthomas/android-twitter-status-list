package com.dogoodapps.domain.threading

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}