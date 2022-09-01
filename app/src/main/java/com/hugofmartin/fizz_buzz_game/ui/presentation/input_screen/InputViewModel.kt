package com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hugofmartin.fizz_buzz_game.domain.use_case.LimitInputValidation
import com.hugofmartin.fizz_buzz_game.domain.use_case.NumberInputValidation
import com.hugofmartin.fizz_buzz_game.domain.use_case.TextInputValidation

class InputViewModel(
    private val numberInputValidation: NumberInputValidation = NumberInputValidation(),
    private val textInputValidation: TextInputValidation = TextInputValidation(),
    private val limitInputValidation: LimitInputValidation = LimitInputValidation()
): ViewModel(){
    private val _state = mutableStateOf(InputState())
    val state: State<InputState> = _state

    fun onEvent(ev: InputEvent) {
        when(ev) {
            is InputEvent.OnFirstNumberChanged -> {
                _state.value = _state.value.copy(
                    firstNumber = ev.value
                )
            }
            is InputEvent.OnSecondNumberChanged -> {
                _state.value = _state.value.copy(
                    secondNumber = ev.value
                )
            }
            is InputEvent.OnFirstTextChanged -> {
                _state.value = _state.value.copy(
                    firstText = ev.value
                )
            }
            is InputEvent.OnSecondTextChanged -> {
                _state.value = _state.value.copy(
                    secondText = ev.value
                )
            }
            is InputEvent.OnLimitChanged -> {
                _state.value = _state.value.copy(
                    limit = ev.value
                )
            }
        }
    }

    fun hasInputError(): Boolean {
        val firstNumberResult = numberInputValidation.execute(_state.value.firstNumber)
        val secondNumberResult = numberInputValidation.execute(_state.value.secondNumber)
        val firstTextResult = textInputValidation.execute(_state.value.firstText)
        val secondTextResult = textInputValidation.execute(_state.value.secondText)
        val limitResult = limitInputValidation.execute(_state.value.limit)

        // Check if any error has occurred
        val hasError = listOf(
            firstNumberResult,
            secondNumberResult,
            firstTextResult,
            secondTextResult,
            limitResult
        ).any { !it.isValid}

        // Update state
        if (hasError) {
            _state.value = _state.value.copy(
                firstNumberErrorMessageResourceId = firstNumberResult.errorRMessageResourceId,
                secondNumberErrorMessageResourceId = secondNumberResult.errorRMessageResourceId,
                firstTextErrorMessageResourceId = firstTextResult.errorRMessageResourceId,
                secondTextErrorMessageResourceId = secondTextResult.errorRMessageResourceId,
                limitErrorMessageResourceId = limitResult.errorRMessageResourceId
            )
        }

        return hasError
    }
}