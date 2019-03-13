package com.dogoodapps.chirp.di

import com.dogoodapps.chirp.ui.main.ChirpActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    // TODO: @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    abstract fun bindChirpActivity(): ChirpActivity
}