package com.example.myapplication.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.data.models.PokemonDetails
import com.example.myapplication.ui.details.PokemonDetailsScreen
import com.example.myapplication.ui.home.HomeScreen
import com.example.myapplication.ui.home.HomeViewModel
import com.example.myapplication.ui.splash.SplashScreen

object PokemonAppDestinations {
    const val SPLASH_ROUTE = "splash"
    const val HOME_ROUTE = "home"
    const val POKEMON_DETAIL = "detail"
}

@Composable
fun PokemonNavGrap() {
    val navController = rememberNavController()
    val viewModel: HomeViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = PokemonAppDestinations.SPLASH_ROUTE
    ) {
        composable(route = PokemonAppDestinations.SPLASH_ROUTE) {
            SplashScreen(navController = navController)
        }
        navigation(
            startDestination = PokemonAppDestinations.HOME_ROUTE, route = "homeNavGraph"
        ) {
            composable(route = PokemonAppDestinations.HOME_ROUTE) { backStackEntry ->
                HomeScreen(navController = navController, viewModel = viewModel)
            }
            composable(route = PokemonAppDestinations.POKEMON_DETAIL) { backStackEntry ->
                PokemonDetailsScreen(navController = navController, viewModel =  viewModel)
            }
        }
    }
}