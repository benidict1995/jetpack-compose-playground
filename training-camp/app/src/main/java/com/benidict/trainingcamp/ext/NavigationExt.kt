package com.benidict.trainingcamp.ext

import androidx.navigation.NavHostController

fun NavHostController.navigateWithPopUp(
    toRoute: String,
    fromRoute: String,
) {
    this.navigate(toRoute) {
        popUpTo(fromRoute) {
            inclusive = true
        }
    }
}
