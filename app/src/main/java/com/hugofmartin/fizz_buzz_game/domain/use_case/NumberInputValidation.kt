package com.hugofmartin.fizz_buzz_game.domain.use_case

import android.content.res.Resources
import com.hugofmartin.fizz_buzz_game.R

class NumberInputValidation {

    fun execute(number: String): ValidationResult {
        if(number.isBlank()) {
            return ValidationResult(
                false,
                R.string.not_blank_error_message
            )
        }
        if(number.toIntOrNull() == null) {
            return ValidationResult(
                false,
                R.string.number_only_error_message
            )
        }
        if(number.toInt() !in 10 downTo 0) {
            return ValidationResult(
                false,
                R.string.number_range_error_message
            )
        }
        return ValidationResult(
            true
        )
    }
}