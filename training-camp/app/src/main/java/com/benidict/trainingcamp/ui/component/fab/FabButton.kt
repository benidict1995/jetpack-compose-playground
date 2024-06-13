package com.benidict.trainingcamp.ui.component.fab

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.benidict.trainingcamp.R
import com.benidict.trainingcamp.ui.component.fab.model.FabItem
import com.benidict.trainingcamp.ui.component.fab.model.FabSubState
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

@Preview
@Composable
fun ViewMultiFloatingButton(){
    MultiFloatingActionButton(fabIcon = painterResource(id = R.drawable.ic_launcher_background), items = arrayListOf(
        FabItem(icon =  painterResource(id = R.drawable.ic_launcher_background), title = "",{})
    ))
}

@Composable
fun MultiFloatingActionButton(
    fabIcon: Painter,
    items: List<FabItem>,
    showLabels: Boolean = true,
    onStateChanged: ((state: FabSubState) -> Unit)? = null
) {
    var currentState by remember { mutableStateOf(FabSubState.COLLAPSED) }
    val stateTransition: Transition<FabSubState> =
        updateTransition(targetState = currentState, label = "")
    val stateChange: () -> Unit = {
        currentState = if (stateTransition.currentState == FabSubState.EXPANDED) {
            FabSubState.COLLAPSED
        } else FabSubState.EXPANDED
        onStateChanged?.invoke(currentState)
    }
    val rotation: Float by stateTransition.animateFloat(
        transitionSpec = {
            if (targetState == FabSubState.EXPANDED) {
                spring(stiffness = Spring.StiffnessLow)
            } else {
                spring(stiffness = Spring.StiffnessMedium)
            }
        },
        label = ""
    ) { state ->
        if (state == FabSubState.EXPANDED) 45f else 0f
    }
    val isEnable = currentState == FabSubState.EXPANDED

    BackHandler(isEnable) {
        currentState = FabSubState.COLLAPSED
    }

    val modifier = if(currentState ==   FabSubState.EXPANDED)
        Modifier
            .fillMaxSize()
            .clickable(indication = null,
                interactionSource = remember { MutableInteractionSource() }) {
                currentState = FabSubState.COLLAPSED
            } else Modifier.fillMaxSize()

    Box(modifier = modifier, contentAlignment = Alignment.BottomEnd) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            if (currentState == FabSubState.EXPANDED) {
                Canvas(modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        scaleX = 2.2f
                        scaleY = 2.1f
                    }) {
                    translate(150f, top = 300f) {
                        scale(5f) {}
                        drawCircle(Color.Gray, radius = 200.dp.toPx())

                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom,
            ) {
                items.forEach { item ->
                    SmallFloatingActionButtonRow(
                        item = item,
                        stateTransition = stateTransition,
                        showLabel = showLabels
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
                FloatingActionButton(
                    shape = CircleShape,
                    containerColor = Color.Blue,
                    onClick = {
                        stateChange()
                    }) {
                    Icon(
                        painter = fabIcon,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.rotate(rotation)
                    )
                }
            }

        }
    }

}


@Composable
fun SmallFloatingActionButtonRow(
    item: FabItem,
    showLabel: Boolean,
    stateTransition: Transition<FabSubState>
) {
    val alpha: Float by stateTransition.animateFloat(
        transitionSpec = {
            tween(durationMillis = 50)
        }, label = ""
    ) { state ->
        if (state == FabSubState.EXPANDED) 1f else 0f
    }
    val scale: Float by stateTransition.animateFloat(
        label = ""
    ) { state ->
        if (state == FabSubState.EXPANDED) 1.0f else 0f
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .alpha(animateFloatAsState((alpha), label = "").value)
            .scale(animateFloatAsState(targetValue = scale, label = "").value)
    ) {
        if (showLabel) {
            Text(
                text = item.title,
                modifier = Modifier
                    .padding(start = 6.dp, end = 6.dp, top = 4.dp, bottom = 4.dp)
                    .clickable(onClick = { item.onItemClicked() })
            )
        }
        SmallFloatingActionButton(
            shape = CircleShape,
            modifier = Modifier
                .padding(4.dp),
            onClick = { item.onItemClicked() },
            containerColor = Color.Blue,
            contentColor = Color.White
        ) {
            Icon(
                painter = item.icon,
                contentDescription = item.title
            )
        }
    }
}