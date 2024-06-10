package com.benidict.trainingcamp.ui.component.fab

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import com.benidict.trainingcamp.ui.component.fab.model.FabItem
import com.benidict.trainingcamp.ui.component.fab.model.FabSubState

@Composable
fun FabSubButton(
    fabIcon: Painter,
    items: List<FabItem>,
    showLabels: Boolean = true,
    onStateChanged: ((state: FabSubState) -> Unit)? = null,
) {
    var state by remember {
        mutableStateOf(FabSubState.COLLAPSED)
    }
    val transition: Transition<FabSubState> =
        updateTransition(targetState = state, label = "")
    val stateChange: () -> Unit = {
        state = if (transition.currentState == FabSubState.EXPANDED) {
            FabSubState.COLLAPSED
        } else {
            FabSubState.EXPANDED
        }
        onStateChanged?.invoke(state)
    }
    val rotation: Float by transition.animateFloat(
        transitionSpec = {
            if (targetState == FabSubState.EXPANDED) {
                spring(stiffness = Spring.StiffnessLow)
            } else {
                spring(stiffness = Spring.StiffnessMedium)
            }
        },
        label = "",
    ) { subState ->
        if (subState == FabSubState.EXPANDED) 45f else 0f
    }
}
