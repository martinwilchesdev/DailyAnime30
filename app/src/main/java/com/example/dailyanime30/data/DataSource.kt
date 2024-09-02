package com.example.dailyanime30.data

import com.example.dailyanime30.R
import com.example.dailyanime30.model.AnimeInfo

class DataSource {
    fun getAnimeInfo(): List<AnimeInfo> {
        return listOf(
            AnimeInfo(R.string.day1, R.string.title1, R.drawable.anime1, R.string.description1)
        )
    }
}