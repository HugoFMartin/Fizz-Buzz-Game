# Fizz-Buzz-Game

A mini-test project.
Version : **1.0**

App contains a form with :
  * Two number inputs, which must be digit
  * two text inputs, which must be one word
  * 1 more number input that define a limit and must be greater than 10

## App goal

The goal of the app is to display a list of number from 1 to the **limit** define in form.

For each **multiple number** of the **first digit** input will be replaced by the **first string** informed in the form and each **multiple number** of the **second digit** will be replaced by the **second string** of the form.

If the number is a multiple of the **first** and the **second digit**, it will be replaced by a **concatenation of the first and the second string**.

# Example

Digit 1 : `3`
Digit 2 : `5`
Word 1 : `Fizz`
Word 2 : `Buzz`
Limit : `16`

Result : `1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16`

## Techno

The app uses Android Kotlin and JetPack Compose<br>
Unit test with Junit4
