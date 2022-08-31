package com.hugofmartin.fizz_buzz_game.domain.use_case

class LimitInputValidation {

    fun execute(limit: String): ValidationResult {
        if(limit.isBlank()) {
            return ValidationResult(
                false,
                "Ce champ doit être rempli"
            )
        }
        if(limit.toIntOrNull() == null) {
            return ValidationResult(
                false,
                "Ce champ ne peut contenir qu'un chiffre"
            )
        }
        if(limit.toInt() < 10) {
            return ValidationResult(
                false,
                "La limite doit être supérieur à 10"
            )
        }
        return ValidationResult(
            true
        )
    }
}