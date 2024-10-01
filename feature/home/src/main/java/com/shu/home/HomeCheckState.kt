package com.shu.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.shu.design_system.state.ErrorScreen
import com.shu.design_system.state.LoadingScreen

@Composable
fun HomeCheckState(
    innerPadding: PaddingValues,
    viewModel: HomeViewModel = hiltViewModel(),
    onItemClick: (Long) -> Unit,
   // onListClick: (FilmVip?) -> Unit,
) {
    val viewState by viewModel.uiState.collectAsState()

    when (viewState) {
        is UiState.Loading -> LoadingScreen()
        is UiState.Success -> {
            with(viewState as UiState.Success) {
                HomeScreen(
                    innerPadding = innerPadding,
                    manyScreens = manyScreens,
                    onItemClick = onItemClick,
                   // onListClick = onListClick
                )
            }
        }

        is UiState.Error -> ErrorScreen(
            message = (viewState as UiState.Error).message,
            retryAction = { viewModel.retry() },
        )
    }
}
