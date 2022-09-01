package com.hugofmartin.fizz_buzz_game.domain.use_case

import android.content.res.Resources
import androidx.compose.ui.res.stringResource
import com.hugofmartin.fizz_buzz_game.R

class LimitInputValidation {

    fun execute(limit: String): ValidationResult {
        if(limit.isBlank()) {
            return ValidationResult(
                false,
                R.string.not_blank_error_message
            )
        }
        if(limit.toIntOrNull() == null) {
            return ValidationResult(
                false,
                R.string.number_only_error_message
            )
        }
        if(limit.toInt() < 10) {
            return ValidationResult(
                false,
                R.string.limit_range_error_message
            )
        }
        return ValidationResult(
            true
        )
    }
}