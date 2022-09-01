package com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen

import java.io.Serializable

data class InputState (
    val firstNumber: String = "3",
    val firstNumberErrorMessage: String? = null,
    val secondNumber: String = "5" ,
    val secondNumberErrorMessage: String? = null,
    val firstText: String = "Fizz",
    val firstTextErrorMessage: String? = null,
    val secondText: String = "Buzz",
    val secondTextErrorMessage: String? = null,
    val limit: String = "30",
    val limitErrorMessage: String? = null
): Serializable