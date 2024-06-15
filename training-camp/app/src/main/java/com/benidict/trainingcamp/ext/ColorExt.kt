package com.benidict.trainingcamp.ext

import androidx.compose.ui.graphics.Color
import com.benidict.domain.model.ItemType
import com.benidict.domain.model.LevelType
import com.benidict.trainingcamp.ui.theme.GreenBackGround

fun exerciseLevelBackground(level: String, item: ItemType? = ItemType.default) = when (level) {
    LevelType.beginner.name -> GreenBackGround
    LevelType.intermediate.name -> Color.Blue
    LevelType.expert.name -> Color.Red
    else -> when (item) {
        ItemType.type -> Color.DarkGray
        ItemType.muscle -> Color.Magenta
        ItemType.equipment -> Color.Gray
        else -> Color.Green
    }
}
