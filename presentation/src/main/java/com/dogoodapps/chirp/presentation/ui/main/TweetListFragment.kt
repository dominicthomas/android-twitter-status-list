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
import com.dogoodapps.chirp.presentation.ui.main.adapters.TweetListAdapter
import com.dogoodapps.chirp.presentation.ui.main.models.TweetListViewModel
import com.dogoodapps.domain.framework.ResourceStatus
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class TweetListFragment : Fragment() {

    companion object {
        fun newInstance(): TweetListFragment {
            return TweetListFragment()
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var tweetListViewModel: TweetListViewModel

    private lateinit var tweetAdapter: TweetListAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tweetAdapter = TweetListAdapter {
            Toast.makeText(context, it.id.toString(), Toast.LENGTH_SHORT).show()
        }
        tweetListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = tweetAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tweetListViewModel = ViewModelProviders.of(this, viewModelFactory).get(TweetListViewModel::class.java)
        tweetListViewModel.getStatusList().observe(this, Observer {
            when (it.resourceStatus) {
                ResourceStatus.SUCCESS -> {
                    tweetAdapter.setItems(it.data ?: emptyList())
                    tweetAdapter.notifyDataSetChanged()
                }
                ResourceStatus.ERROR -> {
                    // TODO: Handle error
                }
                ResourceStatus.LOADING -> {
                    // TODO: Handle loading
                }
            }
        })
        tweetListViewModel.loadStatusList(getString(R.string.dummy_list_id))
    }
}
