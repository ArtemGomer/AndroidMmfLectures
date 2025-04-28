package me.gomer.nsu_mmf.network

data class ArticlesResponse(
    val articles: List<ArticleDTO>
)

data class ArticleDTO(
    val title: String,
    val description: String,
)