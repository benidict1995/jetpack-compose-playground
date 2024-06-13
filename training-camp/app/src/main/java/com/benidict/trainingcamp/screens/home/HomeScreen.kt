package com.benidict.trainingcamp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.benidict.trainingcamp.R
import com.benidict.trainingcamp.ui.component.fab.MultiFloatingActionButton
import com.benidict.trainingcamp.ui.component.fab.model.FabItem
import com.benidict.trainingcamp.ui.theme.PrimaryBlue
import com.benidict.trainingcamp.ui.theme.TertiaryBlue02

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<HomeViewModel>()
    LaunchedEffect(Unit) {
        viewModel.loadExercises()
    }
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = PrimaryBlue,
                    titleContentColor = TertiaryBlue02,
                ),
                title = {
                    Text(
                        "Training Camp",
                    )
                },
            )
        },
        floatingActionButton = {
            MultiFloatingActionButton(
                fabIcon = painterResource(id = R.drawable.ic_launcher_background),
                items = arrayListOf(
                    FabItem(
                        icon = painterResource(id = R.drawable.ic_launcher_background),
                        title = "Button 1",
                    ) {
                    },
                ),
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding),
        ) {
        }
    }
}
