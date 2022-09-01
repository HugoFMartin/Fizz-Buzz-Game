package com.hugofmartin.fizz_buzz_game.domain.use_case

data class ValidationResult(
    val isValid: Boolean,
    val errorRMessageResourceId: Int? = null
)
