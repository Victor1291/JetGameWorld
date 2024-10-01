package com.shu.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.shu.models.ManyScreens

@Composable
fun HomeScreen(
    manyScreens: ManyScreens,
    innerPadding: PaddingValues,
    onItemClick: (Long) -> Unit,
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







