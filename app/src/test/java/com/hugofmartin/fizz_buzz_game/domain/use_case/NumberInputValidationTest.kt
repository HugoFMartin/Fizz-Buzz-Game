package com.hugofmartin.fizz_buzz_game.domain.use_case

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class NumberInputValidationTest: TestCase() {

    private lateinit var numberInputValidation: NumberInputValidation

    @Before
    override fun setUp() {
        numberInputValidation = NumberInputValidation()
    }

    @Test
    fun `test correct number input`() {
        val res = numberInputValidation.execute("6")
        assertEquals(res.isValid, true)
    }

    @Test
    fun `test blank number`() {
        val res = numberInputValidation.execute("")
        assertEquals(res.isValid, false)
    }

    @Test
    fun `test wrong range number`() {
        val res = numberInputValidation.execute("14")
        assertEquals(res.isValid, false)
    }
}