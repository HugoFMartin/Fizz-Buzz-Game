package com.hugofmartin.fizz_buzz_game.domain.use_case

import junit.framework.TestCase
import org.junit.Test
import org.junit.Before
import java.util.*

class LimitInputValidationTest : TestCase(){

    private lateinit var limitInputValidation: LimitInputValidation

    @Before
    override fun setUp() {
        limitInputValidation = LimitInputValidation()
    }

    @Test
    fun `test correct limit input`() {
        val res = limitInputValidation.execute("42")
        assertEquals(res.isValid,true)
    }

    @Test
    fun `test blank limit`() {
        val res = limitInputValidation.execute("")
        assertEquals(res.isValid,false)
    }

    @Test
    fun `test less than 10 limit`() {
        val res = limitInputValidation.execute("8")
        assertEquals(res.isValid,false)
    }

    @Test
    fun `test none number limit`() {
        val res = limitInputValidation.execute("45/.€")
        assertEquals(res.isValid,false)
    }
}