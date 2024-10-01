package com.shu.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shu.design_system.component.ItemCard
import com.shu.design_system.component.ItemTextCardCard
import com.shu.design_system.component.RowTwoText
import com.shu.models.Game
import com.shu.models.GameShort

@Composable
fun LazyRowList(
    modifier: Modifier = Modifier,
    list: List<Game>,
    title: String,
    onItemClick: (Int) -> Unit,
    state: LazyListState = rememberLazyListState(),
    state2: LazyListState = rememberLazyListState(),
    //onListClick: (FilmVip?) -> Unit,
) {

    var listGames by remember { mutableStateOf(emptyList<GameShort>()) }
    var oldId by remember { mutableStateOf(0) } //для проверки нажатия на другой айтем.
    var oldTitle by remember { mutableStateOf("") } //для проверки нажатия на другой айтем.

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
                ItemCard(
                    game,
                    onItemClick = {
                        listGames =
                            if (listGames.isEmpty()) game.games else if (game.id != oldId) game.games else emptyList()
                        oldId = game.id ?: 0
                        oldTitle = game.title
                    })
            }
        }

        if (listGames.isNotEmpty()) {

            RowTwoText(
                first = oldTitle,
                second = "All",
                onClick = { })

            LazyRow(
                contentPadding = PaddingValues(4.dp), modifier = modifier, state = state2
            ) {
                items(listGames) { game ->
                    ItemTextCardCard(game, onItemClick = { listGames = emptyList() })
                }
            }
        }
    }
}


