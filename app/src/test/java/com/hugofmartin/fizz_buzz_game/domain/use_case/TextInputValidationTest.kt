package com.hugofmartin.fizz_buzz_game.domain.use_case

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class TextInputValidationTest : TestCase() {

    private lateinit var textInputValidation: TextInputValidation

    @Before
    override fun setUp() {
        textInputValidation = TextInputValidation()
    }

    @Test
    fun `test correct text input`() {
        val res = textInputValidation.execute("Fizz")
        assertEquals(res.isValid, true)
    }

    @Test
    fun `test blank text`() {
        val res = textInputValidation.execute("")
        assertEquals(res.isValid, false)
    }

    @Test
    fun `test multiple words text`() {
        val res = textInputValidation.execute("hello world, I love Android")
        assertEquals(res.isValid, false)
    }
}