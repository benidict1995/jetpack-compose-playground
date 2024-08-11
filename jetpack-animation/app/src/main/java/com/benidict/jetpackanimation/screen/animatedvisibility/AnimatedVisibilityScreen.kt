package com.benidict.jetpackanimation.screen.animatedvisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.benidict.jetpackanimation.R
import com.benidict.jetpackanimation.component.MainLayoutView
import com.benidict.jetpackanimation.ui.theme.JetpackanimationTheme

@Composable
fun AnimatedVisibilityScreen() {
    val visible by remember {
        mutableStateOf(true)
    }
    val density = LocalDensity.current
    MainLayoutView(
        title = stringResource(R.string.animated_visibility)
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(
                top = 30.dp
            )
        ) {
            AnimatedVisibility(
                visible = visible,
                enter = slideInVertically {
                    with(density) {
                        -40.dp.roundToPx()
                    }
                } + expandVertically(
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    initialAlpha = 0.3f
                ),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                Text(stringResource(R.string.animated_visibility_desc))
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AnimatedVisibilityScreenPreview() {
    JetpackanimationTheme {
        AnimatedVisibilityScreen()
    }
}