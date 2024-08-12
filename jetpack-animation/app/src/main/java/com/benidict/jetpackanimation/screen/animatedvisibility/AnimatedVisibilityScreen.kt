package com.benidict.jetpackanimation.screen.animatedvisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.benidict.jetpackanimation.R
import com.benidict.jetpackanimation.component.MainLayoutView
import com.benidict.jetpackanimation.ui.theme.JetpackanimationTheme

@Composable
fun AnimatedVisibilityScreen(navHostController: NavHostController) {
    val visible by remember {
        mutableStateOf(true)
    }
    var visibilityState by remember {
        mutableStateOf(true)
    }
    val density = LocalDensity.current
    MainLayoutView(
        navController = navHostController,
        title = stringResource(R.string.animated_visibility)
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .then(
                    Modifier.padding(padding)
                )
        ) {
            AnimatedVisibility(
                visible = visible,
                enter = slideIn(
                    tween(
                        100, easing = LinearOutSlowInEasing
                    )
                ){ fullSize ->
                    IntOffset(fullSize.width / 4, 100)
                },
                exit = slideOut(
                    tween(
                        100, easing = FastOutSlowInEasing
                    )
                ) {
                    IntOffset(-180, 50)
                }
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                visibilityState = visibilityState.not()
                            }
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.TopEnd),
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            text = stringResource(
                                if (visibilityState) {
                                    R.string.show
                                } else {
                                    R.string.hide
                                }
                            )
                        )
                    }
                    AnimatedVisibility(visibilityState) {
                        if (visibilityState) {
                            Text(stringResource(R.string.animated_visibility_desc))
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AnimatedVisibilityScreenPreview() {
    JetpackanimationTheme {
        AnimatedVisibilityScreen(NavHostController(LocalContext.current))
    }
}