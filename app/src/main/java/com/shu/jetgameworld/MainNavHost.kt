package com.shu.jetgameworld

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shu.home.HomeCheckState


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier,
    sheetState: SheetState,
    innerPadding: PaddingValues,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {

    val context = LocalContext.current.applicationContext

    NavHost(
        navController = navController,
        startDestination = NavigationScreens.MainScreen.route
    ) {
        composable(NavigationScreens.MainScreen.route) {
            HomeCheckState(
                innerPadding = innerPadding,
                onItemClick = { id ->
                },
            )
        }

        //ProfileScreen
        composable(NavigationScreens.ProfileScreen.route) {

            BackHandler {
                navController.popBackStack()
            }
        }

        //SearchScreen
        composable(
            route = NavigationScreens.SearchScreen.route
        ) {


            BackHandler {
                navController.popBackStack()
            }
        }
    }
}


