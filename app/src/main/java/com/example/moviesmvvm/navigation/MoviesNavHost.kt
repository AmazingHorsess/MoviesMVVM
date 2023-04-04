package com.example.moviesmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesmvvm.screens.DetailScreen
import com.example.moviesmvvm.screens.MainScreen
import com.example.moviesmvvm.screens.SplashScreen
import com.example.moviesmvvm.utils.Screens.DETAILS
import com.example.moviesmvvm.utils.Screens.MAIN
import com.example.moviesmvvm.utils.Screens.SPLASH

sealed class NavRoute(val route: String){
    object Splash: NavRoute(SPLASH)
    object Main: NavRoute(MAIN)
    object Details: NavRoute(DETAILS)

}

@Composable
fun MoviesNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoute.Splash.route){
        composable(NavRoute.Splash.route){ SplashScreen(navController = navController) }
        composable(NavRoute.Main.route){ MainScreen(navController = navController) }
        composable(NavRoute.Details.route){ DetailScreen(navController = navController) }
    }

}