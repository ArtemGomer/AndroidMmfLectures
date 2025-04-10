package me.gomer.nsu_mmf.second.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.gomer.nsu_mmf.Item
import me.gomer.nsu_mmf.R
import me.gomer.nsu_mmf.databinding.HeaderItemBinding
import me.gomer.nsu_mmf.databinding.ListItemBinding

class AsyncListItemAdapter : ListAdapter<Item, RecyclerView.ViewHolder>(ListItemDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        when (viewType){
            R.layout.list_item -> {
                val binding = ListItemBinding.inflate(inflater, parent, false)
                return ItemViewHolder(binding)
            }
            R.layout.header_item -> {
                val binding = HeaderItemBinding.inflate(inflater, parent, false)
                return HeaderViewHolder(binding)
            }
            else -> error("Error")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> holder.bind((getItem(position) as ListItem))
            is HeaderViewHolder -> holder.bind((getItem(position) as HeaderItem))
            else -> error("Error")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ListItem -> R.layout.list_item
            is HeaderItem -> R.layout.header_item
            else -> error("Error")
        }
    }
}

object ListItemDiffUtil : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return when (oldItem) {
            is ListItem -> (newItem as ListItem) == oldItem
            is HeaderItem -> (newItem as HeaderItem) == oldItem
            else -> error("Error")
        }
    }


}