package com.hugofmartin.fizz_buzz_game.domain.use_case

import android.content.res.Resources
import com.hugofmartin.fizz_buzz_game.R

class TextInputValidation {

    fun execute(text: String): ValidationResult{
        if(text.isBlank()) {
            return ValidationResult(
                false,
                R.string.not_blank_error_message
            )
        }
        if(text.contains(" ")){
            return ValidationResult(
                false,
                R.string.text_error_message
            )
        }
        return ValidationResult(
            true
        )
    }
}