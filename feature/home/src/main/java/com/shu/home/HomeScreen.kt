package com.shu.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.shu.home.model.ManyScreens

@Composable
fun HomeScreen(
    manyScreens: ManyScreens,
    innerPadding: PaddingValues,
    onItemClick: (Int) -> Unit,
    //onListClick: (FilmVip?) -> Unit,
) {



    LazyColumn(contentPadding = innerPadding) {

        items(manyScreens.homeListScreen.size) { num ->

            LazyRowList(
                list = manyScreens.homeListScreen[num],
                title = manyScreens.listTitle[num],
                onItemClick = onItemClick,
                //onListClick = onListClick
            )

        }

    }
}


/*
1. по клику на платформу и девелоперсов выводить список игр под ними.

2. для игр также можно выводить список и детальную информацию.

 */




