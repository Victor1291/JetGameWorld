package com.shu.home.model

import androidx.paging.compose.LazyPagingItems
import com.shu.models.Game

data class ManyScreens(
    val homeListScreen: List<LazyPagingItems<Game>>,
    val listTitle: List<String>,
)
