package com.dogoodapps.chirp.presentation.di

import com.dogoodapps.chirp.presentation.ui.main.ChirpActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    abstract fun bindChirpActivity(): ChirpActivity
}