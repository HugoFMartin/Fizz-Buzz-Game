package com.hugofmartin.fizz_buzz_game.domain.use_case

import androidx.compose.runtime.mutableStateListOf
import junit.framework.TestCase
import org.junit.Test
import org.junit.Before
import java.util.*

class FizzBuzzTest : TestCase(){

    private lateinit var fizzBuzz: FizzBuzz

    @Before
    override fun setUp() {
        fizzBuzz = FizzBuzz()
    }

    @Test
    fun `test correct FizzBuzz`() {
        val expectedRes = ArrayList(mutableStateListOf(
            "1",
            "2",
            "Fizz",
            "4",
            "Buzz",
            "Fizz",
            "7",
            "8",
            "Fizz",
            "Buzz",
            "11",
            "Fizz",
            "13",
            "14",
            "FizzBuzz",
            "16",
            "17",
            "Fizz",
            "19",
            "Buzz",
            "Fizz",
            "22",
            "23",
            "Fizz",
            "Buzz",
            "26",
            "Fizz",
            "28",
            "29",
            "FizzBuzz",
        ))
        val res = fizzBuzz(3,5,"Fizz","Buzz",30)
        assertEquals(res,expectedRes)
    }
}