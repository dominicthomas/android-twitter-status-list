package com.dogoodapps.statuslist.presentation.ui.main.di

import com.dogoodapps.statuslist.presentation.ui.main.TweetListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuilder {


    @ContributesAndroidInjector
    internal abstract fun bindTweetListFragment(): TweetListFragment
}
