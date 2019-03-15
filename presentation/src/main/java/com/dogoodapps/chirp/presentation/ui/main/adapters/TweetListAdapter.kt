package com.dogoodapps.chirp.presentation.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dogoodapps.chirp.R
import com.dogoodapps.domain.entities.Tweet

class TweetListAdapter(val onClick: (Tweet) -> Unit) : RecyclerView.Adapter<TweetItemViewHolder>() {

    private var items: List<Tweet> = emptyList()

    fun setItems(newItems: List<Tweet>) {
        items = newItems
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetItemViewHolder = TweetItemViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.tweet_list_item, parent, false)
    )

    override fun onBindViewHolder(holder: TweetItemViewHolder, position: Int) {
        holder.bind(items[position])
        holder.view.setOnClickListener { onClick(items[position]) }
    }
}
