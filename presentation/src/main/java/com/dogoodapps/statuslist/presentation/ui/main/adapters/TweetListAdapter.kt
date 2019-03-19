package com.dogoodapps.statuslist.presentation.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dogoodapps.statuslist.R
import com.dogoodapps.statuslist.presentation.ui.framework.ImageLoader
import com.dogoodapps.domain.models.TweetDomainModel

class TweetListAdapter(
    private val onClick: (TweetDomainModel) -> Unit,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<TweetItemViewHolder>() {

    private var items: List<TweetDomainModel> = emptyList()

    fun setItems(newItems: List<TweetDomainModel>) {
        items = newItems
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetItemViewHolder = TweetItemViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.tweet_list_item, parent, false)
    )

    override fun onBindViewHolder(holder: TweetItemViewHolder, position: Int) {
        holder.bind(items[position], imageLoader)
        holder.view.setOnClickListener { onClick(items[position]) }
    }
}
