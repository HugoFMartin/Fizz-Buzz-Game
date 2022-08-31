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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hugofmartin.fizz_buzz_game.ui.presentation.util.Screen

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
            text = "FizzBuzz Game",
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
                    title = "1er chiffre",
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier
                )
                FormInput(
                    value = state.value.secondNumber,
                    onValueChange = {
                        viewModel.onEvent(InputEvent.OnSecondNumberChanged(it))
                    },
                    title = "2ème chiffre",
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier
                )
                FormInput(
                    value = state.value.firstText,
                    onValueChange = {
                        viewModel.onEvent(InputEvent.OnFirstTextChanged(it))
                    },
                    title = "1er mot",
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier
                )
                FormInput(
                    value = state.value.secondText,
                    onValueChange = {
                        viewModel.onEvent(InputEvent.OnSecondTextChanged(it))
                    },
                    title = "1er mot",
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier
                )
                FormInput(
                    value = state.value.limit,
                    onValueChange = {
                        viewModel.onEvent(InputEvent.OnLimitChanged(it))
                    },
                    title = "Limite",
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    // Navigate to the FizzBuzz screen and cast value to int, we sure they can't be null or ""
                    onClick = {
                        navController.navigate(
                            Screen.FizzBuzzScreen.route +
                                    "?firstNumber=${state.value.firstNumber.toInt()}&" +
                                    "secondNumber=${state.value.secondNumber.toInt()}&" +
                                    "firstText=${state.value.firstText}&" +
                                    "secondText=${state.value.secondText}&" +
                                    "limit=${state.value.limit.toInt()}",
                        )
                    }
                ) {
                    Text(text = "Valider")
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
    modifier: Modifier
) {
    Text(
        text = title,
        fontSize = 14.sp,
        color = MaterialTheme.colors.primary
    )
    TextField(
        modifier = modifier.padding(top = 4.dp,bottom = 8.dp),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}