package com.benidict.jetpackanimation.ui.buttons

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun ButtonMenuView(
    title: String,
    content: @Composable () -> Unit
) {
    var rememberClick by remember {
        mutableStateOf(false)
    }
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            rememberClick = true
        }
    ) {
        Text(
            text = title
        )
        if (rememberClick) {
            rememberClick = false
            content()
        }
    }
}
