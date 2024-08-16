package com.benidict.jetpackanimation.screen.animatedcontent

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.benidict.jetpackanimation.R
import com.benidict.jetpackanimation.component.MainLayoutView

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentScreen(navHostController: NavHostController) {
    MainLayoutView(navHostController, stringResource(R.string.animated_content)) { padding ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(padding)
                .then(Modifier.padding(start = 20.dp, end = 20.dp, top = 10.dp))
        ) {
            var count by remember {
                mutableStateOf(0)
            }
            Column {
                Button(onClick = { count++ }) {
                    Text("Add")
                }
                Button(onClick = {
                    if (count > 0) {
                        count--
                    }
                }) {
                    Text("Minus")
                }
            }
            Spacer(
                modifier = Modifier.height(10.dp).width(30.dp)
            )
            AnimatedContent(targetState = count,
                transitionSpec = {
                    if (targetState > initialState) {
                        slideInVertically { height -> height } + fadeIn() with
                                slideOutVertically { height -> -height } + fadeOut()
                    } else {
                        slideInVertically { height -> -height } + fadeIn() with
                                slideOutVertically { height -> height } + fadeOut()
                    }.using(
                        SizeTransform(clip = false)
                    )
                }) { targetCount ->
                // Make sure to use `targetCount`, not `count`.
                Text(text = "Count: $targetCount")
            }
        }
    }
}