package com.dogoodapps.chirp.di

import com.dogoodapps.chirp.ui.main.ChirpFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuilder {

    // TODO: @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeChirpFragment(): ChirpFragment
}
