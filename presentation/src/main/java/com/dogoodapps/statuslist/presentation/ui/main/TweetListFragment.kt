package com.dogoodapps.statuslist.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dogoodapps.statuslist.R
import com.dogoodapps.statuslist.presentation.ui.framework.BaseInjectingFragment
import com.dogoodapps.statuslist.presentation.ui.framework.ImageLoader
import com.dogoodapps.statuslist.presentation.ui.main.adapters.TweetListAdapter
import com.dogoodapps.statuslist.presentation.ui.main.models.TweetListViewModel
import com.dogoodapps.domain.models.TweetDomainModel
import com.dogoodapps.domain.framework.Resource
import com.dogoodapps.domain.framework.ResourceStatus
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class TweetListFragment : BaseInjectingFragment<MainActivity>() {

    companion object {
        fun newInstance(): TweetListFragment {
            return TweetListFragment()
        }
    }

    @Inject
    lateinit var imageLoader: ImageLoader

    private lateinit var tweetListViewModel: TweetListViewModel

    private lateinit var tweetAdapter: TweetListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tweetAdapter = TweetListAdapter({
            Toast.makeText(context, it.id.toString(), Toast.LENGTH_SHORT).show()
        }, imageLoader)
        tweetListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = tweetAdapter
        }
        tweetListViewModel = ViewModelProviders.of(this, viewModelFactory).get(TweetListViewModel::class.java)
        tweetListViewModel.getStatusList().observe(this, StatusObserver())
        tweetListViewModel.loadStatusList(getString(R.string.dummy_list_id))
        swipeRefreshLayout.setOnRefreshListener {
            tweetListViewModel.loadStatusList(getString(R.string.dummy_list_id))
            getInjectingActivity().showLoading(false)
        }
    }

    private inner class StatusObserver : Observer<Resource<List<TweetDomainModel>>> {
        override fun onChanged(resouce: Resource<List<TweetDomainModel>>?) {
            when (resouce?.resourceStatus) {
                ResourceStatus.SUCCESS -> {
                    getInjectingActivity().showLoading(false)
                    swipeRefreshLayout.isRefreshing = false
                    tweetAdapter.setItems(resouce.data ?: emptyList())
                    tweetAdapter.notifyDataSetChanged()
                }
                ResourceStatus.ERROR -> {
                    getInjectingActivity().showLoading(false)
                    swipeRefreshLayout.isRefreshing = false
                    Toast.makeText(context, resouce.message, Toast.LENGTH_SHORT).show()
                }
                ResourceStatus.LOADING -> {
                    tweetAdapter.setItems(emptyList())
                    tweetAdapter.notifyDataSetChanged()
                    getInjectingActivity().showLoading(true)
                }
            }
        }
    }
}
