package com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hugofmartin.fizz_buzz_game.ui.presentation.util.Screen
import com.hugofmartin.fizz_buzz_game.R

@Composable
fun InputScreen(
    viewModel: InputViewModel,
    navController: NavController
){

    val state = viewModel.state

    Column {
        Text(
            modifier= Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = stringResource(id = R.string.input_screen_title),
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                FormInput(
                    value = state.value.firstNumber,
                    onValueChange = {
                        viewModel.onEvent(InputEvent.OnFirstNumberChanged(it))
                    },
                    title = stringResource(id = R.string.first_number_label),
                    keyboardType = KeyboardType.Number,
                    errorMessage = state.value.firstNumberErrorMessageResourceId,
                    modifier = Modifier
                )
                FormInput(
                    value = state.value.secondNumber,
                    onValueChange = {
                        viewModel.onEvent(InputEvent.OnSecondNumberChanged(it))
                    },
                    title = stringResource(id = R.string.second_number_label),
                    keyboardType = KeyboardType.Number,
                    errorMessage = state.value.secondNumberErrorMessageResourceId,
                    modifier = Modifier
                )
                FormInput(
                    value = state.value.firstText,
                    onValueChange = {
                        viewModel.onEvent(InputEvent.OnFirstTextChanged(it))
                    },
                    title = stringResource(id = R.string.first_text_label),
                    keyboardType = KeyboardType.Text,
                    errorMessage = state.value.firstTextErrorMessageResourceId,
                    modifier = Modifier
                )
                FormInput(
                    value = state.value.secondText,
                    onValueChange = {
                        viewModel.onEvent(InputEvent.OnSecondTextChanged(it))
                    },
                    title = stringResource(id = R.string.second_text_label),
                    keyboardType = KeyboardType.Text,
                    errorMessage = state.value.secondTextErrorMessageResourceId,
                    modifier = Modifier
                )
                FormInput(
                    value = state.value.limit,
                    onValueChange = {
                        viewModel.onEvent(InputEvent.OnLimitChanged(it))
                    },
                    title = stringResource(id = R.string.limit_label),
                    keyboardType = KeyboardType.Number,
                    errorMessage = state.value.limitErrorMessageResourceId,
                    modifier = Modifier
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    // Navigate to the FizzBuzz screen and cast value to int, we sure input can't be null
                    onClick = {
                        if (!viewModel.hasInputError()) {
                            navController.navigate(
                                Screen.FizzBuzzScreen.route +
                                        "?firstNumber=${state.value.firstNumber.toInt()}&" +
                                        "secondNumber=${state.value.secondNumber.toInt()}&" +
                                        "firstText=${state.value.firstText}&" +
                                        "secondText=${state.value.secondText}&" +
                                        "limit=${state.value.limit.toInt()}",
                            )
                        }
                    }
                ) {
                    Text(text = stringResource(id = R.string.validate))
                }
            }
        }
    }
}

@Composable
fun FormInput(
    value: String,
    onValueChange: (String) -> Unit,
    title: String,
    keyboardType: KeyboardType,
    errorMessage: Int?,
    modifier: Modifier
) {
    Text(
        text = title,
        fontSize = 14.sp,
        color = MaterialTheme.colors.primary
    )
    TextField(
        modifier = modifier.padding(top = 2.dp,bottom = 2.dp),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        isError = errorMessage != null
    )
    if (errorMessage != null) {
        Text(
            modifier = modifier.padding(bottom = 8.dp),
            text = stringResource(id = errorMessage),
            color = MaterialTheme.colors.error,
            fontSize = 14.sp,
        )
    }
}