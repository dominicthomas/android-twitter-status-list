package com.dogoodapps.chirp.presentation.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dogoodapps.domain.entities.Status
import kotlinx.android.synthetic.main.status_list_item.view.*

class StatusItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(status: Status) {
        itemView.statusText.text = status.full_text
    }
}
