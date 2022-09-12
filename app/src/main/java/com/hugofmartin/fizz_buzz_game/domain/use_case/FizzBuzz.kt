package com.hugofmartin.fizz_buzz_game.domain.use_case

import com.hugofmartin.fizz_buzz_game.data.model.Inputs
import java.util.*

class FizzBuzz {

    operator fun invoke(inputs: Inputs): MutableList<String> {
        val resArray = mutableListOf<String>()

        for (i in 1..inputs.limit) {
            if (i % inputs.firstNumber == 0 && i % inputs.secondNumber == 0) {
                resArray.add(inputs.firstText + inputs.secondText)
            } else if (i % inputs.firstNumber == 0) {
                resArray.add(inputs.firstText)
            } else if (i % inputs.secondNumber == 0) {
                resArray.add(inputs.secondText)
            } else {
                resArray.add(i.toString())
            }
        }
        return resArray
    }
}