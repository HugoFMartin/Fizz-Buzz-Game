package com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen

data class InputState (
    val firstNumber: Int = 3,
    val secondNumber: Int = 5 ,
    val firstText: String = "Fizz",
    val secondText: String = "Buzz",
    val limit: Int = 30
)