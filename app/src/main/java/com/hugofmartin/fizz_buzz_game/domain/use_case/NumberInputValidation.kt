package com.hugofmartin.fizz_buzz_game.domain.use_case

class NumberInputValidation {

    fun execute(number: String): ValidationResult {
        if(number.isBlank()) {
            return ValidationResult(
                false,
                "Ce champ doit être rempli"
            )
        }
        if(number.toIntOrNull() == null) {
            return ValidationResult(
                false,
                "Ce champ ne peut contenir qu'un chiffre"
            )
        }
        if(number.toInt() !in 10 downTo 0) {
            return ValidationResult(
                false,
                "Le chiffre doit être compris entre 1 et 9 inclus"
            )
        }
        return ValidationResult(
            true
        )
    }
}