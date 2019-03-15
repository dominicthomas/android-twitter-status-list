package com.dogoodapps.chirp.presentation.ui.main

import android.os.Bundle
import com.dogoodapps.chirp.R
import com.dogoodapps.chirp.presentation.ui.framework.BaseInjectingActivity

class TweetListActivity : BaseInjectingActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_chirp
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(R.id.container, TweetListFragment.newInstance())
    }
}
