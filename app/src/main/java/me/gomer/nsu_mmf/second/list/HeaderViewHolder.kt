package me.gomer.nsu_mmf.second.list

import androidx.recyclerview.widget.RecyclerView
import me.gomer.nsu_mmf.databinding.HeaderItemBinding

class HeaderViewHolder(
    private val binding: HeaderItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(headerItem: HeaderItem) {
        binding.header.text = headerItem.header
    }
}