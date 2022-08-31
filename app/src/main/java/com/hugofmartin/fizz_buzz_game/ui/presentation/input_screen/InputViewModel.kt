package com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class InputViewModel : ViewModel(){
    private val _state = mutableStateOf(InputState())
    val state: State<InputState> = _state

    fun onEvent(ev: InputEvent) {
        when(ev) {
            is InputEvent.OnFirstNumberChanged -> {
                _state.value = _state.value.copy(
                    firstNumber = ev.value
                )
            }
            is InputEvent.OnSecondNumberChanged -> {
                _state.value = _state.value.copy(
                    secondNumber = ev.value
                )
            }
            is InputEvent.OnFirstTextChanged -> {
                _state.value = _state.value.copy(
                    firstText = ev.value
                )
            }
            is InputEvent.OnSecondTextChanged -> {
                _state.value = _state.value.copy(
                    secondText = ev.value
                )
            }
            is InputEvent.OnLimitChanged -> {
                _state.value = _state.value.copy(
                    limit = ev.value
                )
            }
        }
    }
}