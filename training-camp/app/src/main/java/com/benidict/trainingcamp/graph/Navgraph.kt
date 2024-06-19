package com.benidict.trainingcamp.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.benidict.domain.model.Exercise
import com.benidict.trainingcamp.route.HomeRoute
import com.benidict.trainingcamp.route.SplashRoute
import com.benidict.trainingcamp.screens.exercisedetails.ExerciseDetailsScreen
import com.benidict.trainingcamp.screens.home.HomeScreen
import com.benidict.trainingcamp.screens.splash.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SplashRoute,
    ) {
        composable<SplashRoute> {
            SplashScreen(navController = navController)
        }
        composable<HomeRoute> {
            HomeScreen(navController = navController)
        }
        composable<Exercise> { backStackEntry ->
            val exercise: Exercise = backStackEntry.toRoute()
            ExerciseDetailsScreen(navController, exercise)
        }
    }
}
