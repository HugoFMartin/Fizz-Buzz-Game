package com.hugofmartin.fizz_buzz_game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hugofmartin.fizz_buzz_game.data.model.Inputs
import com.hugofmartin.fizz_buzz_game.ui.presentation.fizz_buzz_screen.FizzBuzzScreen
import com.hugofmartin.fizz_buzz_game.ui.presentation.input_screen.InputScreen
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
                                viewModel = viewModel(),
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
                                viewModel(),
                                navController = navController,
                                inputs = Inputs(
                                    backStackEntry.arguments?.getInt("firstNumberInput")!!,
                                    backStackEntry.arguments?.getInt("secondNumberInput")!!,
                                    backStackEntry.arguments?.getString("firstTextInput")!!,
                                    backStackEntry.arguments?.getString("secondTextInput")!!,
                                    backStackEntry.arguments?.getInt("limitInput")!!
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

