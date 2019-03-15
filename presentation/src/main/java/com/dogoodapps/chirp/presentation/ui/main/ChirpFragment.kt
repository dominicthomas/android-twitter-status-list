package com.dogoodapps.chirp.presentation.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dogoodapps.chirp.R
import com.dogoodapps.chirp.presentation.ui.adapters.StatusListAdapter
import com.dogoodapps.chirp.presentation.ui.models.TweetListViewModel
import com.dogoodapps.domain.framework.Status
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

    private lateinit var tweetListViewModel: TweetListViewModel

    private lateinit var adapter: StatusListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = StatusListAdapter {
            Toast.makeText(context, it.id.toString(), Toast.LENGTH_SHORT).show()
        }
        tweetListRecyclerView.layoutManager = LinearLayoutManager(context)
        tweetListRecyclerView.adapter = adapter
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chip, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tweetListViewModel = ViewModelProviders.of(this, viewModelFactory).get(TweetListViewModel::class.java)
        tweetListViewModel.getStatusList().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    adapter.setItems(it.data ?: emptyList())
                }
                Status.ERROR -> {
                }/*statusResponseCount.text = it.message*/
                Status.LOADING -> {
                }
            }
        })
        tweetListViewModel.loadStatusList(getString(R.string.dummy_list_id))
    }
}
