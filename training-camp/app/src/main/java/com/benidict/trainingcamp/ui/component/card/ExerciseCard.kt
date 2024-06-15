package com.benidict.trainingcamp.ui.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benidict.domain.model.Exercise
import com.benidict.domain.test.exercise
import com.benidict.trainingcamp.ext.exerciseLevelBackground
import com.benidict.trainingcamp.ui.theme.sfProFamily

@Composable
fun ExerciseCard(exercise: Exercise, onClick: (Exercise) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(.5.dp, shape = RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp))
            .background(color = Color.White, shape = RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp))
            .clickable {
                onClick(exercise)
            },
    ) {
        Column(modifier = Modifier.padding(16.dp, 10.dp, 16.dp, 10.dp)) {
            Box(
                modifier = Modifier
                    .background(
                        color = exerciseLevelBackground(exercise.difficulty),
                        shape = RoundedCornerShape(4.dp, 4.dp, 4.dp, 4.dp),
                    ),
            ) {
                Text(
                    modifier = Modifier.padding(5.dp, 2.dp, 5.dp, 2.dp),
                    text = exercise.difficulty,
                    color = Color.White,
                )
            }
            Text(
                text = exercise.name,
                fontFamily = sfProFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
            )
            Text(
                text = exercise.instructions,
                fontSize = 13.sp,
                fontFamily = sfProFamily,
                fontWeight = FontWeight.Normal,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 15.sp,
            )
        }
    }
}

@Composable
@Preview
fun ExerciseCardPreview() {
    ExerciseCard(
        exercise,
    ) {
    }
}
