package com.example.composestate

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    WellnessTasksList(list = wellnessViewModel.tasks, onCloseTask = {task -> wellnessViewModel.remove(task)}, onCheckedTask = {task, checked -> wellnessViewModel.changeTaskChecked(task, checked)}, modifier = modifier)
}