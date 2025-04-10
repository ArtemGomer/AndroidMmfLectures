package me.gomer.nsu_mmf.second.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.gomer.nsu_mmf.Item
import me.gomer.nsu_mmf.R
import me.gomer.nsu_mmf.databinding.HeaderItemBinding
import me.gomer.nsu_mmf.databinding.ListItemBinding

class ListItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<Item> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

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
            is ItemViewHolder -> holder.bind((items[position] as ListItem))
            is HeaderViewHolder -> holder.bind((items[position] as HeaderItem))
            else -> error("Error")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ListItem -> R.layout.list_item
            is HeaderItem -> R.layout.header_item
            else -> error("Error")
        }
    }
}