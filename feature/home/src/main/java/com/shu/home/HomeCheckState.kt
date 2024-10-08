package com.shu.home

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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


    var listTitle by remember {
        mutableStateOf(
            listOf(
                "Choice Genre",
                "Choice Platform",
                "All Games",
                "Playstation 4",
                "Popular",
                "Released",
                "Nintendo Switch",
                "Last Year",
            )
        )
    }

    //val choiceGenre = viewModel.choiceGenre.collectAsLazyPagingItems()

    val listAllGame = viewModel.listAllGame.collectAsLazyPagingItems()

   /* val listGamePlatforms = viewModel.listGamePlatforms.collectAsLazyPagingItems()
    val listPlaystation = viewModel.listPlaystation.collectAsLazyPagingItems()
    val listPopular = viewModel.listPopular.collectAsLazyPagingItems()
    val listReleased = viewModel.listReleased.collectAsLazyPagingItems()
    val listWaiting = viewModel.listWaiting.collectAsLazyPagingItems()
    val listLastYear = viewModel.listLastYear.collectAsLazyPagingItems()*/

    val homeListScreen by remember {
        mutableStateOf(
            listOf(
//                choiceGenre,
//                listGamePlatforms,
                listAllGame,
//                listPlaystation,
//                listPopular,
//                listReleased,
//                listWaiting,
//                listLastYear
            )
        )
    }

    HomeScreen(
        viewModel = viewModel,
        innerPadding = innerPadding,
        manyScreens = ManyScreens(
            homeListScreen = homeListScreen,
            listTitle = listTitle
        ),
        onItemClick = onItemClick,
        onGenreClick = { id, title ->
            Log.d("genrecheck", "ID =  $id  and title = $title")
           // viewModel.setGenre(id)
        },
        onPlatformClick = { id, title ->
            //viewModel.setPlatform(id)
        },

        // onListClick = onListClick
    )
}



