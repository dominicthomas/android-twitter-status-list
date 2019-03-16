package com.dogoodapps.chirp.presentation.ui.main.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dogoodapps.data.framework.twitterFriendlyDate
import com.dogoodapps.chirp.presentation.ui.main.models.TweetViewModel
import kotlinx.android.synthetic.main.tweet_list_item.view.*


class TweetItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(tweetViewModel: TweetViewModel) {
        itemView.statusDate.text = tweetViewModel.created_at.twitterFriendlyDate()
        itemView.statusText.text = tweetViewModel.full_text
    }
}
