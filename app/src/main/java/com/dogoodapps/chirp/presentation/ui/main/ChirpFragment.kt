package com.dogoodapps.chirp.presentation.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dogoodapps.chirp.R
import com.dogoodapps.chirp.domain.framework.Status
import com.dogoodapps.chirp.presentation.ui.models.StatusViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_chip.*
import javax.inject.Inject


class ChirpFragment : Fragment() {

    companion object {
        fun newInstance(): ChirpFragment {
            return ChirpFragment()
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var statusViewModel: StatusViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chip, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        statusViewModel = ViewModelProviders.of(this, viewModelFactory).get(StatusViewModel::class.java)
        statusViewModel.getStatusList(getString(R.string.dummy_list_id))
            .observe(this, Observer {
                when (it.status) {
                    Status.SUCCESS -> statusResponseCount.text = it.data?.size.toString()
                    Status.ERROR -> statusResponseCount.text = it.message
                    Status.LOADING -> {
                    }
                }
            })
    }
}