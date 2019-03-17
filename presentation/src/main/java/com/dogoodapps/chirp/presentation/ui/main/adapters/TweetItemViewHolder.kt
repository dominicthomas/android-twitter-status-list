package com.dogoodapps.chirp.presentation.ui.main.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dogoodapps.data.model.TweetDataModel
import kotlinx.android.synthetic.main.tweet_list_item.view.*


class TweetItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(tweetViewModel: TweetDataModel) {
        itemView.statusDate.text = tweetViewModel.created_at
        itemView.statusText.text = tweetViewModel.full_text
    }
}
