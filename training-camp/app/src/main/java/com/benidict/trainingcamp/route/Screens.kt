package com.benidict.trainingcamp.route

sealed class Screens(val route: String) {
    object Splash : Screens("splash_screen")
    object Home : Screens("home_screen")
}
