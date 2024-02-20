package com.cs4520.assignment3

class CalculatorModel {
    fun add(num1: Double, num2: Double): Double = num1 + num2
    fun subtract(num1: Double, num2: Double): Double = num1 - num2
    fun multiply(num1: Double, num2: Double): Double = num1 * num2
    fun divide(num1: Double, num2: Double): Double {
        if (num2 == 0.0) {
            throw IllegalArgumentException("Cannot divide by zero")
        }
        return num1 / num2
    }
}