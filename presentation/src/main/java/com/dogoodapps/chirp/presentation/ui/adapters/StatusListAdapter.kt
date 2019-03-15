package com.dogoodapps.chirp.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dogoodapps.chirp.R
import com.dogoodapps.domain.entities.Status

class StatusListAdapter(val onClick: (Status) -> Unit) : RecyclerView.Adapter<StatusItemViewHolder>() {

    private var items: List<Status> = emptyList()

    fun setItems(newItems: List<Status>) {
        items = newItems
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusItemViewHolder = StatusItemViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.status_list_item, parent, false)
    )

    override fun onBindViewHolder(holder: StatusItemViewHolder, position: Int) {
        holder.bind(items[position])
        holder.view.setOnClickListener { onClick(items[position]) }
    }
}
