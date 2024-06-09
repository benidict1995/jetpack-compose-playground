package com.benidict.trainingcamp.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.benidict.trainingcamp.route.Screens
import com.benidict.trainingcamp.screens.home.HomeScreen
import com.benidict.trainingcamp.screens.splash.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}
