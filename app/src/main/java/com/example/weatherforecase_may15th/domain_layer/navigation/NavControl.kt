package com.example.weatherforecase_may15th.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weatherforecase_may15th.presentation_layer.views.MainScreen
import com.example.weatherforecase_may15th.presentation_layer.views.MainScreen.MainViewModel
import com.example.weatherforecase_may15th.presentation_layer.views.SearchScreen.SearchScreen
import com.example.weatherforecase_may15th.presentation_layer.views.SplashScreen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NavControl() {
    // Global NavController to remember
    // Provided with time I can handel Navigation state with single instance
    val mNavController = rememberNavController()
    NavHost(navController = mNavController, startDestination = NavigationScreens.SplashScreen.name){
        composable(NavigationScreens.SplashScreen.name){
            SplashScreen(navController=mNavController)
        }

        // Main Screen Navigation
        val route = NavigationScreens.MainScreen.name
        composable("$route/{city}",
            arguments = listOf(
                navArgument(name = "city"){
                    type = NavType.StringType
                })){ navBack ->
            navBack.arguments?.getString("city").let { city ->

                val mainViewModel = hiltViewModel<MainViewModel>()
                MainScreen(navController = mNavController, mainViewModel,
                    city = city)
            }

        }

        // SearchScreen Navigation
        composable(NavigationScreens.SearchScreen.name){
            SearchScreen(navController = mNavController)
        }
    }
}