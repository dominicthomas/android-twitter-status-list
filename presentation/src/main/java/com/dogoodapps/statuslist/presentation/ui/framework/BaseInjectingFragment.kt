package com.dogoodapps.statuslist.presentation.ui.framework

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseInjectingFragment<T : BaseInjectingActivity> : Fragment() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var activity: T

    @Suppress("UNCHECKED_CAST")
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        activity = context as T
    }

    protected fun getInjectingActivity(): T {
        return activity
    }
}