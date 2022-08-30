package com.hugofmartin.fizz_buzz_game.use_case

import java.util.*

class FizzBuzz {

    operator fun invoke(firstNumber: Int, secondNumber: Int, firstText: String, secondText: String, limit: Int): ArrayList<String> {
        val resArray = ArrayList<String>()

        for (i in 1..limit) {
            if (i % firstNumber == 0 && i % secondNumber == 0) {
                resArray.add(firstText + secondText)
            } else if (i % firstNumber == 0) {
                resArray.add(firstText)
            } else if (i % secondNumber == 0) {
                resArray.add(secondText)
            } else {
                resArray.add(i.toString())
            }
        }
        return resArray
    }
}