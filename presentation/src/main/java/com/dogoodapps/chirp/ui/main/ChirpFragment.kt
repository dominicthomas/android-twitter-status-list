package com.dogoodapps.chirp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dogoodapps.chirp.R

class ChirpFragment : Fragment() {

    companion object {
        fun newInstance(): ChirpFragment {
            return ChirpFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chip, container, false)
    }
}