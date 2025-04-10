package me.gomer.nsu_mmf.second.list

import me.gomer.nsu_mmf.Item

data class ListItem(
    val text: String,
    val imageId: Int,
    override val id: Int,
): Item
