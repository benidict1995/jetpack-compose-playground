package com.benidict.trainingcamp.screens.exercisedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.benidict.domain.model.Exercise
import com.benidict.domain.model.ItemType
import com.benidict.domain.test.exercise
import com.benidict.domain.utils.displayFormalText
import com.benidict.trainingcamp.ui.component.card.LevelCards
import com.benidict.trainingcamp.ui.theme.LightGrayBackground
import com.benidict.trainingcamp.ui.theme.PrimaryBlue
import com.benidict.trainingcamp.ui.theme.TertiaryBlue02
import com.benidict.trainingcamp.ui.theme.sfProFamily

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ExerciseDetailsScreen(navController: NavHostController, exercise: Exercise) {
    Scaffold(
        containerColor = LightGrayBackground,
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = PrimaryBlue,
                    titleContentColor = TertiaryBlue02,
                ),
                title = {
                    Text(
                        exercise.name,
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        },
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "",
                            tint = Color.White,
                        )
                    }
                },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding),
        ) {
            Column(
                modifier = Modifier.padding(16.dp, 10.dp, 16.dp, 10.dp),
            ) {
                FlowRow(modifier = Modifier.padding(0.dp)) {
                    LevelCards(exercise.difficulty)
                    LevelCards(
                        exercise.type.displayFormalText(
                            "_",
                            " ",
                        ),
                        ItemType.type,
                    )
                    LevelCards(
                        exercise.muscle.displayFormalText(
                            "_",
                            " ",
                        ),
                        ItemType.muscle,

                    )
                    LevelCards(
                        exercise.equipment.displayFormalText(
                            "_",
                            " ",
                        ),
                        ItemType.equipment,
                    )
                }
                Text(
                    text = exercise.name,
                    fontFamily = sfProFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp),
                )
                Text(
                    text = exercise.instructions,
                    fontSize = 13.sp,
                    fontFamily = sfProFamily,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 15.sp,
                    modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 0.dp),
                    textAlign = TextAlign.Justify,
                )
            }
        }
    }
}

@Composable
@Preview
fun ExerciseDetailsScreenPreview() {
    ExerciseDetailsScreen(NavHostController(LocalContext.current), exercise)
}
