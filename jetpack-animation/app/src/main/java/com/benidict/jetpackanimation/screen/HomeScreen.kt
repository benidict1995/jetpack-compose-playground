package com.benidict.jetpackanimation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.benidict.jetpackanimation.R
import com.benidict.jetpackanimation.component.MainLayoutView
import com.benidict.jetpackanimation.navigation.route.AnimatedVisibilityRoute
import com.benidict.jetpackanimation.screen.animatedvisibility.AnimatedVisibilityScreen
import com.benidict.jetpackanimation.ui.buttons.ButtonMenuView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    MainLayoutView(
        navController = navController,
        title = stringResource(R.string.app_name)
    ) { padding ->
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
                .padding(padding)
        ) {
            ButtonMenuView(
                title = stringResource(R.string.animated_visibility)
            ) {
                navController.navigate(AnimatedVisibilityRoute)
            }

            ButtonMenuView(
                title = stringResource(R.string.animate_content_size)
            ) {

            }

            ButtonMenuView(
                title = stringResource(R.string.animated_content)
            ) {

            }

            ButtonMenuView(
                title = stringResource(R.string.animate_as_state)
            ) {

            }

            ButtonMenuView(
                title = stringResource(R.string.transition)
            ) {

            }

            ButtonMenuView(
                title = stringResource(R.string.infinite_transition)
            ) {

            }
        }
    }
}