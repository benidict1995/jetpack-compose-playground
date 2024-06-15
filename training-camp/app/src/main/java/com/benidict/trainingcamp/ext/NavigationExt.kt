package com.benidict.trainingcamp.ext

import androidx.navigation.NavHostController

fun NavHostController.navigateWithPopUp(
    toRoute: Any,
    fromRoute: Any,
) {
    this.navigate(toRoute) {
        popUpTo(fromRoute) {
            inclusive = true
        }
    }
}
