package me.gomer.nsu_mmf.second

import me.gomer.nsu_mmf.Item
import me.gomer.nsu_mmf.R
import me.gomer.nsu_mmf.second.list.HeaderItem
import me.gomer.nsu_mmf.second.list.ListItem

class SecondMapper {

    fun getListItems(): List<Item> {
        return listOf(
            ListItem(
                text = "Android",
                imageId = R.drawable.android_24,
                id = 0,
            ),
            ListItem(
                text = "Discord",
                imageId = R.drawable.discord_24,
                id = 1,
            ),
            HeaderItem(
                header = "Header1",
                id = 2,
            ),
            ListItem(
                text = "GitHub",
                imageId = R.drawable.github_24,
                id = 3,
            ),
            ListItem(
                text = "Telegram",
                imageId = R.drawable.telegram_24,
                id = 4,
            ),
            ListItem(
                text = "Twitter",
                imageId = R.drawable.twitter_24,
                id = 5,
            ),
            HeaderItem(
                header = "Header2",
                id = 6,
            ),
            ListItem(
                text = "VK",
                imageId = R.drawable.vk_24,
                id = 7,
            ),
            ListItem(
                text = "YouTube",
                imageId = R.drawable.youtube_24,
                id = 8,
            ),
            ListItem(
                text = "Android",
                imageId = R.drawable.android_24,
                id = 9,
            ),
            HeaderItem(
                header = "Header3",
                id = 10,
            ),
            ListItem(
                text = "Discord",
                imageId = R.drawable.discord_24,
                id = 11,
            ),
            ListItem(
                text = "GitHub",
                imageId = R.drawable.github_24,
                id = 12,
            ),
            ListItem(
                text = "Telegram",
                imageId = R.drawable.telegram_24,
                id = 13,
            ),
            ListItem(
                text = "Twitter",
                imageId = R.drawable.twitter_24,
                id = 14,
            ),
            HeaderItem(
                header = "Header4",
                id = 15,
            ),
            ListItem(
                text = "VK",
                imageId = R.drawable.vk_24,
                id = 16,
            ),
            ListItem(
                text = "YouTube",
                imageId = R.drawable.youtube_24,
                id = 17,
            ),
        )
    }
}