package com.shu.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.shu.design_system.component.ItemCard
import com.shu.design_system.component.ItemImageCard
import com.shu.design_system.component.ItemTextCard
import com.shu.design_system.component.RowThreeText
import com.shu.design_system.component.RowTwoText
import com.shu.models.GameDbo
import com.shu.models.GameShort
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LazyRowList(
    modifier: Modifier = Modifier,
    list: LazyPagingItems<GameDbo>,
    title: String,
    onItemClick: (Int) -> Unit,
    onGenreClick: (Int, String) -> Unit,
    onPlatformClick: (Int, String) -> Unit,
    num: Int,
    state: LazyGridState = rememberLazyGridState(),
    state2: LazyListState = rememberLazyListState(),
    state3: LazyListState = rememberLazyListState(),
    state4: LazyListState = rememberLazyListState(),
    //onListClick: (FilmVip?) -> Unit,
) {

    var listGames by remember { mutableStateOf(emptyList<GameShort>()) }
    var game by remember { mutableStateOf(emptyList<GameDbo>()) }
    var oldId by remember { mutableIntStateOf(0) } //для проверки нажатия на другой айтем.
    var oldTitle by remember { mutableStateOf("") } //для проверки нажатия на другой айтем.

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = 1) {
        val max = 7
        coroutineScope.launch {
            while (true) {
                repeat(max) {
                    delay(2000)
                    state3.animateScrollToItem(state3.firstVisibleItemIndex + 1)
                }
                state3.scrollToItem(0)
            }
        }
    }

    Column(
        modifier = Modifier
    ) {

        RowTwoText(
            first = title,
            second = list.itemCount.toString(),
            onClick = { })

        if (game.isNotEmpty()) {
            val g = game.first()

            Text(
                text = oldTitle,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 4.dp),
                color = MaterialTheme.colorScheme.primary
            )

            RowThreeText(
                rowId = g.id ?: 0,
                rating = g.rating.toString(),
                first = g.platforms ?: "",
                second = g.genres ?: "",
            ) {

            }

            LazyRow(
                contentPadding = PaddingValues(4.dp), modifier = modifier, state = state3,
            ) {
                items(g.shortScreenshots) { pl ->
                    pl.image?.let {
                        ItemImageCard(
                            image = it,
                            onItemClick = { game = emptyList() }
                        )
                    }
                }
            }

        }

        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            contentPadding = PaddingValues(4.dp),
            modifier = modifier.height(370.dp),
            state = state
        ) {

            if (list.loadState.refresh == LoadState.Loading) {
                item {
                    Text(
                        text = "Waiting for items to load from the backend",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
            }



            items(count = list.itemCount) { index ->
                val item = list[index]
                if (item != null) {
                    ItemCard(
                        item,
                        onItemClick = {// Проверка на какой список нажата кнопка.

                            game =
                                if (game.isEmpty()) listOf(item) else if (item.id != oldId) listOf(
                                    item
                                ) else emptyList()
                            oldId = item.id ?: 0
                            oldTitle = item.title

                            /*when (num) {

                                0 -> {
                                    Log.d(
                                        "clickLog",
                                        "num = $num  click item ${item.id} ***************"
                                    )
                                    onGenreClick(item.id ?: 5, item.title)
                                }

                                1 -> {
                                    Log.d(
                                        "clickLog",
                                        "num = $num  click item ${item.id}  ***************"
                                    )
                                    onPlatformClick(item.id ?: 7, item.title)
                                }

//                                else -> {
//                                    listGames =
//                                        if (listGames.isEmpty()) item.games else if (item.id != oldId) item.games else emptyList()
//                                    game =
//                                        if (game.isEmpty()) listOf(item) else if (item.id != oldId) listOf(
//                                            item
//                                        ) else emptyList()
//                                    oldId = item.id ?: 0
//                                    oldTitle = item.title
//                                }
                            }*/
                        })
                }
            }
        }

        if (listGames.isNotEmpty()) {

            RowTwoText(
                first = oldTitle,
                second = list.itemCount.toString(),
                onClick = { })

            LazyRow(
                contentPadding = PaddingValues(4.dp), modifier = modifier, state = state2
            ) {
                items(listGames) { game ->
                    game.title?.let { ItemTextCard(it, onItemClick = { listGames = emptyList() }) }
                }
            }
        }
    }
}


