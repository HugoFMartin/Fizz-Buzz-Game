package com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen

sealed class InputUIEvent {
    data class OnFirstNumberChanged(val value: String): InputUIEvent()
    data class OnSecondNumberChanged(val value: String): InputUIEvent()
    data class OnFirstTextChanged(val value: String): InputUIEvent()
    data class OnSecondTextChanged(val value: String): InputUIEvent()
    data class OnLimitChanged(val value: String): InputUIEvent()
    object OnValidateInputs: InputUIEvent()
}