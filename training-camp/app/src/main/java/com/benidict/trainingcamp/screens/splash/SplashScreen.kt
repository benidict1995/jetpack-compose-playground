package com.benidict.trainingcamp.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.benidict.trainingcamp.R
import com.benidict.trainingcamp.ext.navigateWithPopUp
import com.benidict.trainingcamp.route.HomeRoute
import com.benidict.trainingcamp.route.SplashRoute
import com.benidict.trainingcamp.ui.theme.PrimaryBlue

@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryBlue),
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.ic_lottie_calendar_2))
        val logoAnimationState =
            animateLottieCompositionAsState(composition = composition)
        LottieAnimation(
            composition = composition,
            progress = { logoAnimationState.progress },
        )
        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
            navController.navigateWithPopUp(HomeRoute, SplashRoute)
        }
    }
}
