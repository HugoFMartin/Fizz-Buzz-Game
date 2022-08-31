package com.hugofmartin.fizz_buzz_game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hugofmartin.fizz_buzz_game.domain.use_case.FizzBuzz
import com.hugofmartin.fizz_buzz_game.ui.presentation.fizz_buzz_screen.FizzBuzzScreen
import com.hugofmartin.fizz_buzz_game.ui.presentation.fizz_buzz_screen.FizzBuzzViewModel
import com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen.InputScreen
import com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen.InputState
import com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen.InputViewModel
import com.hugofmartin.fizz_buzz_game.ui.presentation.util.Screen
import com.hugofmartin.fizz_buzz_game.ui.theme.FizzBuzzGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FizzBuzzGameTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.InputScreen.route
                    ) {
                        composable(route = Screen.InputScreen.route) {
                            InputScreen(
                                InputViewModel(),
                                navController = navController,
                            )
                        }
                        composable(
                            route = Screen.FizzBuzzScreen.route +
                                    "?firstNumber={firstNumberInput}&" +
                                    "secondNumber={secondNumberInput}&" +
                                    "firstText={firstTextInput}&" +
                                    "secondText={secondTextInput}&" +
                                    "limit={limitInput}",
                            arguments = listOf(
                                navArgument(
                                    name = "firstNumberInput"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "secondNumberInput"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "firstTextInput"
                                ) {
                                    type = NavType.StringType
                                    defaultValue = ""
                                },
                                navArgument(
                                    name = "secondTextInput"
                                ) {
                                    type = NavType.StringType
                                    defaultValue = ""
                                },
                                navArgument(
                                    name = "limitInput"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) { backStackEntry ->
                            FizzBuzzScreen(
                                FizzBuzzViewModel(FizzBuzz()),
                                navController = navController,
                                firstNumber = backStackEntry.arguments?.getInt("firstNumberInput"),
                                secondNumber = backStackEntry.arguments?.getInt("secondNumberInput"),
                                firstText = backStackEntry.arguments?.getString("firstTextInput"),
                                secondText = backStackEntry.arguments?.getString("secondTextInput"),
                                limit = backStackEntry.arguments?.getInt("limitInput")
                            )
                        }
                    }
                }
            }
        }
    }
}

