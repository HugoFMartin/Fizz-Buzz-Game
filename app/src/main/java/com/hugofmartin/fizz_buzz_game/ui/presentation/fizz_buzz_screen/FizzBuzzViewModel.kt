package com.hugofmartin.fizz_buzz_game.ui.presentation.fizz_buzz_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hugofmartin.fizz_buzz_game.domain.use_case.FizzBuzz

class FizzBuzzViewModel(
    fizzBuzz: FizzBuzz = FizzBuzz()
): ViewModel() {

    private val _state = mutableStateOf(FizzBuzzState())
    val state: State<FizzBuzzState> = _state

    init {
        _state.value = state.value.copy(
            list = fizzBuzz(3,5,"fizz","buzz",30)
        )
    }

}