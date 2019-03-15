package com.dogoodapps.chirp.presentation.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dogoodapps.chirp.presentation.ui.framework.ViewModelFactory
import com.dogoodapps.chirp.presentation.ui.framework.ViewModelKey
import com.dogoodapps.chirp.presentation.ui.main.models.TweetListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TweetListViewModel::class)
    internal abstract fun tweetListViewModel(viewModel: TweetListViewModel): ViewModel
}
