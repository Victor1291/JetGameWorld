package com.shu.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.paging.compose.collectAsLazyPagingItems
import com.shu.home.model.ManyScreens

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    manyScreens: ManyScreens,
    innerPadding: PaddingValues,
    onItemClick: (Int) -> Unit,
    onGenreClick: (Int, String) -> Unit,
    onPlatformClick: (Int, String) -> Unit,
) {

    var isSeeGenre by remember { mutableStateOf(false) }
    var isSeePlatform by remember { mutableStateOf(false) }

    LazyColumn(contentPadding = innerPadding) {

        item {
            if (isSeeGenre) {
                LazyRowList(
                    list = viewModel.listOfGenre.collectAsLazyPagingItems(),
                    title = "Genre New",
                    onItemClick = onItemClick,
                    onGenreClick = { id, title ->
                        onGenreClick(id, title)
                    },
                    onPlatformClick = { id, title ->
                        onPlatformClick(id, title)
                    },
                    num = 2,
                    //onListClick = onListClick
                )
            }
        }

        item {
            LazyRowList(
                list = manyScreens.homeListScreen[0],
                title = "Choice Genre",
                onItemClick = onItemClick,
                onGenreClick = { id, title ->
                    isSeeGenre = false
                    onGenreClick(id, title)
                    isSeeGenre = true
                },
                onPlatformClick = { id, title ->
                    isSeePlatform = false
                    onPlatformClick(id, title)
                    isSeePlatform = true // TODO сделать оключение по клику.
                },
                num = 0,
                //onListClick = onListClick
            )
        }

        item {
            if (isSeePlatform) {
                LazyRowList(
                    list = viewModel.listOfPlatform.collectAsLazyPagingItems(),
                    title = "Platform Games",
                    onItemClick = onItemClick,
                    onGenreClick = { id, title ->
                        onGenreClick(id, title)
                    },
                    onPlatformClick = { id, title ->
                        onPlatformClick(id, title)
                    },
                    num = 2,
                    //onListClick = onListClick
                )
            }
        }

        item {
            LazyRowList(
                list = manyScreens.homeListScreen[1],
                title = "Choice Platform",
                onItemClick = onItemClick,
                onGenreClick = { id, title ->
                    isSeeGenre = false
                    onGenreClick(id, title)
                    isSeeGenre = true
                },
                onPlatformClick = { id, title ->
                    isSeePlatform = false
                    onPlatformClick(id, title)
                    isSeePlatform = true
                },
                num = 1,
                //onListClick = onListClick
            )
        }

        items(manyScreens.homeListScreen.size) { num ->

            if (num > 1) { // показывать списки со второго, так как первый выше показан
                LazyRowList(
                    list = manyScreens.homeListScreen[num],
                    title = manyScreens.listTitle[num],
                    onItemClick = onItemClick,
                    onGenreClick = { id, title ->
                        onGenreClick(id, title)
                        isSeeGenre = true
                    },
                    onPlatformClick = { id, title ->
                        onPlatformClick(id, title)
                        isSeePlatform = true
                    },

                    num = num,
                    //onListClick = onListClick
                )
            }
        }
    }
}


/*
1. по клику на платформу и девелоперсов выводить список игр под ними.

2. для игр также можно выводить список и детальную информацию.
3. разделить items на item по порядку.
 */




