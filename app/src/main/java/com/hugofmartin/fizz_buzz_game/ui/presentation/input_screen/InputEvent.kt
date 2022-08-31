package com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen

sealed class InputEvent {
    data class OnFirstNumberChanged(val value: String): InputEvent()
    data class OnSecondNumberChanged(val value: String): InputEvent()
    data class OnFirstTextChanged(val value: String): InputEvent()
    data class OnSecondTextChanged(val value: String): InputEvent()
    data class OnLimitChanged(val value: String): InputEvent()
}