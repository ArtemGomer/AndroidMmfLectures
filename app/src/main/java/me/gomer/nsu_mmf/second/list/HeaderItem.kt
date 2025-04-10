package me.gomer.nsu_mmf.second.list

import me.gomer.nsu_mmf.Item

data class HeaderItem(
    val header: String,
    override val id: Int
): Item