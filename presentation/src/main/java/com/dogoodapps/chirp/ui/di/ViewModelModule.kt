package com.dogoodapps.chirp.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dogoodapps.chirp.ui.framework.ViewModelFactory
import com.dogoodapps.chirp.ui.framework.ViewModelKey
import com.dogoodapps.chirp.ui.models.StatusViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(StatusViewModel::class)
    internal abstract fun statusListViewModel(viewModel: StatusViewModel): ViewModel
}
