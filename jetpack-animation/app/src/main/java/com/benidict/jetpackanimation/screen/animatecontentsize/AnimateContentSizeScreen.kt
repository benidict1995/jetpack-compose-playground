package com.benidict.jetpackanimation.screen.animatecontentsize

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.benidict.jetpackanimation.R
import com.benidict.jetpackanimation.component.MainLayoutView

@Composable
fun AnimateContentSizeScreen(
    navHostController: NavHostController
) {
    var expanded by remember { mutableStateOf(false) }
    MainLayoutView(
        navController = navHostController,
        title = stringResource(R.string.animate_content_size)
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .background(color = Color.Blue)
                .animateContentSize()
                .height(if (expanded) 400.dp else 100.dp)
                .fillMaxWidth()
                .then(
                    Modifier.padding(start = 20.dp, end = 20.dp)
                )
        ) {
            Spacer(
                modifier = Modifier
                    .height(5.dp)
                    .fillMaxWidth()
            )
            Text(
                color = Color.White,
                text = "Use animateContentSize() to achieve automatic size change animations."
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth()
            )
            Box(
                contentAlignment = if (expanded) Alignment.BottomCenter else Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    color = Color.White,
                    text = if (expanded) "" else "Click me!",
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        expanded = expanded.not()
                    }
                )

                Text(
                    color = Color.White,
                    text = if (expanded) "Close" else "",
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        expanded = expanded.not()
                    }
                )
            }
        }
    }
}
