package com.hugofmartin.fizz_buzz_game.ui.presentation.fizz_buzz_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hugofmartin.fizz_buzz_game.R

@Composable
fun FizzBuzzScreen(
    viewModel: FizzBuzzViewModel,
    navController: NavController,
    firstNumber: Int?,
    secondNumber: Int?,
    firstText: String?,
    secondText: String?,
    limit: Int?,
    ) {
    val state = viewModel.state

    viewModel.executeFizzBuzz(
        firstNumber!!,
        secondNumber!!,
        firstText!!,
        secondText!!,
        limit!!
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier= Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = stringResource(id = R.string.fizzbuzz_screen_title),
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3
        )
        LazyColumn(
            Modifier.weight(1f)
        ) {
            items(
                state.value.list
            ) {
                ListItem(
                    Modifier.fillMaxWidth(),
                    it
                )
            }
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text(
                text = stringResource(id = R.string.retry)
            )
        }

    }
}

@Composable
fun ListItem(
    modifier: Modifier,
    item: String
) {
    Row(
        modifier = modifier
            .padding(4.dp)
    ) {
        Text(
            modifier =modifier,
            text = item,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            fontSize = 15.sp
        )
    }
}