package com.benidict.jetpackanimation.navigation.host

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.benidict.jetpackanimation.navigation.route.AnimateContentSizeRoute
import com.benidict.jetpackanimation.navigation.route.AnimatedContentRoute
import com.benidict.jetpackanimation.navigation.route.AnimatedVisibilityRoute
import com.benidict.jetpackanimation.navigation.route.HomeRoute
import com.benidict.jetpackanimation.screen.HomeScreen
import com.benidict.jetpackanimation.screen.animatecontentsize.AnimateContentSizeScreen
import com.benidict.jetpackanimation.screen.animatedcontent.AnimatedContentScreen
import com.benidict.jetpackanimation.screen.animatedvisibility.AnimatedVisibilityScreen

@Composable
fun MainGraph(navHostController: NavHostController) {
    NavHost(navHostController, startDestination = HomeRoute) {
        composable<HomeRoute> {
            HomeScreen(navHostController)
        }
        composable<AnimatedVisibilityRoute> {
            AnimatedVisibilityScreen(navHostController)
        }
        composable<AnimateContentSizeRoute> {
            AnimateContentSizeScreen(navHostController)
        }
        composable<AnimatedContentRoute> {
            AnimatedContentScreen(navHostController)
        }
    }
}