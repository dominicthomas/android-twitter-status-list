package com.dogoodapps.chirp.ui.main

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.dogoodapps.chirp.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class ChirpActivity : AppCompatActivity() {

    @Inject
    lateinit var app: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chirp)
        supportFragmentManager.commit(allowStateLoss = true) {
            replace(R.id.container, ChirpFragment.newInstance())
        }
    }
}
