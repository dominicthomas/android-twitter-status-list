package com.dogoodapps.chirp.presentation.di

import com.dogoodapps.chirp.presentation.ui.main.ChirpFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuilder {

    // TODO: @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeChirpFragment(): ChirpFragment
}
