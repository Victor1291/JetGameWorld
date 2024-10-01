package com.shu.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shu.design_system.component.ItemCard
import com.shu.design_system.component.RowTwoText
import com.shu.models.Game

@Composable
fun LazyRowList(
    modifier: Modifier = Modifier,
    list: List<Game>,
    title: String,
    onItemClick: (Long) -> Unit,
    state: LazyListState = rememberLazyListState(),
    //onListClick: (FilmVip?) -> Unit,
) {

    Column(
        modifier = Modifier
    ) {

        RowTwoText(
            first = title,
            second = "All",
            onClick = { })

        LazyRow(
            contentPadding = PaddingValues(4.dp), modifier = modifier, state = state
        ) {
            items(list) { game ->
                ItemCard(game, onItemClick = onItemClick)
            }
        }
    }
}


