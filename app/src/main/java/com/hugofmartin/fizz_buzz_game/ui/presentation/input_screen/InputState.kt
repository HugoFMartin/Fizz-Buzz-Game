package com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen

import java.io.Serializable

data class InputState (
    val firstNumber: String = "3",
    val firstNumberErrorMessageResourceId: Int? = null,
    val secondNumber: String = "5",
    val secondNumberErrorMessageResourceId: Int? = null,
    val firstText: String = "Fizz",
    val firstTextErrorMessageResourceId: Int? = null,
    val secondText: String = "Buzz",
    val secondTextErrorMessageResourceId: Int? = null,
    val limit: String = "30",
    val limitErrorMessageResourceId: Int? = null
): Serializable