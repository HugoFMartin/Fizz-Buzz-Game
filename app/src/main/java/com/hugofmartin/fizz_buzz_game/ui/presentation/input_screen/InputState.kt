package com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen

import java.io.Serializable

data class InputState (
    val firstNumber: String = "3",
    val secondNumber: String = "5" ,
    val firstText: String = "Fizz",
    val secondText: String = "Buzz",
    val limit: String = "30"
): Serializable