package com.hugofmartin.fizz_buzz_game.ui.presentation.util

sealed class Screen(val route: String) {
    object InputScreen: Screen("input_screen")
    object FizzBuzzScreen: Screen("fizzbuzz_screen")
}