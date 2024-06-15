package com.benidict.trainingcamp.ui.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.benidict.domain.model.ItemType
import com.benidict.domain.test.exercise
import com.benidict.trainingcamp.ext.exerciseLevelBackground
import com.benidict.trainingcamp.ui.theme.sfProFamily

@Composable
fun LevelCards(level: String, item: ItemType? = ItemType.default) {
    Box(
        modifier = Modifier
            .padding(start = 4.dp, top = 2.dp)
            .background(
                color = exerciseLevelBackground(level, item),
                shape = RoundedCornerShape(4.dp, 4.dp, 4.dp, 4.dp),
            ),
    ) {
        Text(
            modifier = Modifier.padding(5.dp, 2.dp, 5.dp, 2.dp),
            text = level,
            color = Color.White,
            fontFamily = sfProFamily,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
@Preview
fun LevelCardsPreview(level: String) {
    LevelCards(exercise.difficulty)
}
