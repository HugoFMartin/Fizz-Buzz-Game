package com.hugofmartin.fizz_buzz_game.domain.use_case

class TextInputValidation {

    fun execute(text: String): ValidationResult{
        if(text.isBlank()) {
            return ValidationResult(
                false,
                "Ce champ doit être rempli"
            )
        }
        if(text.contains(" ")){
            return ValidationResult(
                false,
                "Ce champ doit être composé d'un seul mot, sans espace"
            )
        }
        return ValidationResult(
            true
        )
    }
}