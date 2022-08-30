package com.hugofmartin.fizz_buzz_game.ui.presentation.fizz_buzz_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FizzBuzzScreen(
    viewModel: FizzBuzzViewModel
) {
    val state = viewModel.state

    Box(modifier = Modifier) {
        state.value.list.forEach {
            Column() {
                Text(text = it)
            }
        }
    }
}