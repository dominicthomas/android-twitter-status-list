package com.dogoodapps.chirp.presentation.ui.main

import android.os.Bundle
import android.view.View
import com.dogoodapps.chirp.R
import com.dogoodapps.chirp.presentation.ui.framework.BaseInjectingActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseInjectingActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(R.id.container, TweetListFragment.newInstance())
    }

    fun showLoading(isLoading: Boolean) {
        loadingSpinner.visibility = if (isLoading) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}
