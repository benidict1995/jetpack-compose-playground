package com.benidict.trainingcamp.ui.component.fab

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.benidict.trainingcamp.R
import com.benidict.trainingcamp.ui.theme.PrimaryBlue

@Composable
@Preview
fun FabButton() {
    FloatingActionButton(
        onClick = {},
        shape = CircleShape,
        containerColor = PrimaryBlue,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 8.dp,
        ),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "",
            tint = Color.White,
        )
    }
}
