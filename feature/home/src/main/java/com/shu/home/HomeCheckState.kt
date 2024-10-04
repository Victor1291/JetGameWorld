package com.shu.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.shu.home.model.ManyScreens

@Composable
fun HomeCheckState(
    innerPadding: PaddingValues,
    viewModel: HomeViewModel = hiltViewModel(),
    onItemClick: (Int) -> Unit,
    // onListClick: (FilmVip?) -> Unit,
) {

    val listGamePlatforms = viewModel.listGamePlatforms.collectAsLazyPagingItems()
    val listDevelopers = viewModel.listDevelopers.collectAsLazyPagingItems()
    val listPlaystation = viewModel.listPlaystation.collectAsLazyPagingItems()
    val listPopular = viewModel.listPopular.collectAsLazyPagingItems()
    val listReleased = viewModel.listReleased.collectAsLazyPagingItems()
    val listWaiting = viewModel.listWaiting.collectAsLazyPagingItems()
    val listLastYear = viewModel.listLastYear.collectAsLazyPagingItems()


    HomeScreen(
        innerPadding = innerPadding,
        manyScreens = ManyScreens(
            homeListScreen = listOf(
                listGamePlatforms,
                listDevelopers,
                listPlaystation,
                listPopular,
                listReleased,
                listWaiting,
                listLastYear
            ),
            listTitle = listOf(
                "Platforms",
                "Developers",
                "Playstation 4",
                "Popular",
                "Released",
                "Nintendo Switch",
                "Last Year",
            )
        ),
        onItemClick = onItemClick,
        // onListClick = onListClick
    )
}



