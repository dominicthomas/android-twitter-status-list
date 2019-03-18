package com.dogoodapps.statuslist.presentation.ui.main.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dogoodapps.statuslist.presentation.ui.framework.ImageLoader
import com.dogoodapps.data.model.TweetDataModel
import kotlinx.android.synthetic.main.tweet_list_item.view.*


class TweetItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(tweetViewModel: TweetDataModel, imageLoader: ImageLoader) {
        imageLoader.load(tweetViewModel.profile_image_url).into(itemView.tweetImage)
        itemView.tweetDate.text = tweetViewModel.created_at
        itemView.tweetText.text = tweetViewModel.full_text
    }
}
