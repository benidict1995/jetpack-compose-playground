package com.benidict.trainingcamp.ui.component.bottomsheet

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBottomSheet(showBottomSheet: Boolean, sheetState: SheetState, scope: CoroutineScope, onUpdateBottomSheet: (Boolean) -> Unit) {
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                onUpdateBottomSheet(false)
            },
            sheetState = sheetState,
        ) {
            // Sheet content
            Button(onClick = {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        onUpdateBottomSheet(false)
                    }
                }
            },) {
                Text("Hide bottom sheet")
            }
        }
    }
}
