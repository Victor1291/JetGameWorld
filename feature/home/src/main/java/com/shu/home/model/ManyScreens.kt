package com.shu.home.model

import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import com.shu.models.Game
import com.shu.models.GameDbo
import kotlinx.coroutines.flow.Flow

data class ManyScreens(
    val homeListScreen: List<LazyPagingItems<GameDbo>>,
    val listTitle: List<String>,
)
