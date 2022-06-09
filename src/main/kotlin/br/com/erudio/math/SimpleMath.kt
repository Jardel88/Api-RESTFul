package br.com.erudio.math

import kotlin.math.sqrt

class SimpleMath {
    //Por se tratar de valores Double, pode ser usado a inferencia
    // que o proprio kotlin ja sabe que sea retornado um valor Double
   // fun sum(numberOne: Double, numberTwo: Double): Double{

    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo

    fun subtraction(numberOne: Double, numberTwo: Double) = numberOne - numberTwo

    fun multplication(numberOne: Double, numberTwo: Double) = numberOne * numberTwo

    fun division(numberOne: Double, numberTwo: Double) = numberOne / numberTwo

    fun mean(numberOne: Double, numberTwo: Double) = (numberOne + numberTwo) / 2

    fun squareRoot(number: Double) = sqrt(number)
}