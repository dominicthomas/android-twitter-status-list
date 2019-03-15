package com.dogoodapps.chirp.presentation.di

import com.dogoodapps.chirp.presentation.ui.main.TweetListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    internal abstract fun contributeChirpFragment(): TweetListFragment
}
