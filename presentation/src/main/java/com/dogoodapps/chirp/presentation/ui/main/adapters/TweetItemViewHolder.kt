package com.dogoodapps.chirp.presentation.ui.main.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dogoodapps.data.framework.twitterFriendlyDate
import com.dogoodapps.domain.entities.Tweet
import kotlinx.android.synthetic.main.tweet_list_item.view.*


class TweetItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(tweet: Tweet) {
        itemView.statusDate.text = tweet.created_at.twitterFriendlyDate()
        itemView.statusText.text = tweet.full_text
    }
}
