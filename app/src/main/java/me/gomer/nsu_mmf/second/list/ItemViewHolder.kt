package me.gomer.nsu_mmf.second.list

import androidx.recyclerview.widget.RecyclerView
import me.gomer.nsu_mmf.databinding.ListItemBinding

class ItemViewHolder(
    private val viewBinding: ListItemBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(listItem: ListItem) {
        viewBinding.text.text = listItem.text
        viewBinding.image.setImageResource(listItem.imageId)
    }

}