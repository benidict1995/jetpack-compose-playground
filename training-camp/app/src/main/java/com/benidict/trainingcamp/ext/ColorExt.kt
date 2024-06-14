package com.benidict.trainingcamp.ext

import androidx.compose.ui.graphics.Color
import com.benidict.trainingcamp.ui.theme.GreenBackGround

fun exerciseLevelBackground(level: String) = when (level) {
    "beginner" -> GreenBackGround
    "intermediate" -> Color.Blue
    "expert" -> Color.Red
    else -> GreenBackGround
}
