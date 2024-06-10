package com.benidict.trainingcamp.ui.component.fab.model

import androidx.compose.ui.graphics.painter.Painter

data class FabItem(
    val icon: Painter,
    val title: String,
    val onItemClicked: () -> Unit,
)
