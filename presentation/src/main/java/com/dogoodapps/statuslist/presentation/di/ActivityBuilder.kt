package com.dogoodapps.statuslist.presentation.di

import com.dogoodapps.statuslist.presentation.ui.di.ActivityScope
import com.dogoodapps.statuslist.presentation.ui.main.di.FragmentBuilder
import com.dogoodapps.statuslist.presentation.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    abstract fun bindTweetListActivity(): MainActivity
}