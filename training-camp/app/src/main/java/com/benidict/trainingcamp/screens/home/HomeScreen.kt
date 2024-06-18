package com.benidict.trainingcamp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.benidict.domain.utils.toJson
import com.benidict.trainingcamp.route.ExerciseDetailsRoute
import com.benidict.trainingcamp.ui.component.card.ExerciseCard
import com.benidict.trainingcamp.ui.theme.LightGrayBackground
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
        containerColor = LightGrayBackground,
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
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding),
        ) {
            val exercises = viewModel.exerciseState.collectAsState()
            Log.d("makerChecker", "exercises:$exercises")
            LazyColumn(modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)) {
                items(exercises.value.size) { index ->
                    HorizontalDivider(color = Color.Transparent, modifier = Modifier.height(10.dp))
                    ExerciseCard(exercise = exercises.value[index]) {
                        navController.navigate(
                            ExerciseDetailsRoute(
                                it.toJson().orEmpty(),
                            ),
                        )
                    }
                }
            }
        }
    }
}
