package com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
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
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                FormInput(
                    value = state.value.firstNumber.toString(),
                    onValueChange = {
                        viewModel.onEvent(InputEvent.OnFirstNumberChanged(it.toInt()))
                    },
                    title = "1er chiffre",
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier
                )
                FormInput(
                    value = state.value.secondNumber.toString(),
                    onValueChange = {
                        viewModel.onEvent(InputEvent.OnSecondNumberChanged(it.toInt()))
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
                    value = state.value.limit.toString(),
                    onValueChange = {
                        viewModel.onEvent(InputEvent.OnLimitChanged(it.toInt()))
                    },
                    title = "Limite",
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    onClick = { /*TODO*/ }
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