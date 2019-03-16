package com.dogoodapps.chirp.presentation.di

import com.dogoodapps.chirp.presentation.ui.di.ActivityScope
import com.dogoodapps.chirp.presentation.ui.di.FragmentBuilder
import com.dogoodapps.chirp.presentation.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    abstract fun bindTweetListActivity(): MainActivity
}