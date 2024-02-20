package com.cs4520.assignment3

class CalculatorPresenter (private val view: CalculatorView, private val model: CalculatorModel) {
    fun add(num1: Double, num2: Double) {
        try {
            val result = model.add(num1, num2)
            view.showResult(result)
        } catch (e: IllegalArgumentException) {
            view.showError(e.message ?: "An error occurred")
        }
    }

    fun subtract(num1: Double, num2: Double) {
        try {
            val result = model.subtract(num1, num2)
            view.showResult(result)
        } catch (e: IllegalArgumentException) {
            view.showError(e.message ?: "An error occurred")
        }
    }

    fun multiply(num1: Double, num2: Double) {
        try {
            val result = model.multiply(num1, num2)
            view.showResult(result)
        } catch (e: IllegalArgumentException) {
            view.showError(e.message ?: "An error occurred")
        }
    }

    fun divide(num1: Double, num2: Double) {
        try {
            val result = model.divide(num1, num2)
            view.showResult(result)
        } catch (e: IllegalArgumentException) {
            view.showError(e.message ?: "An error occurred")
        }
    }

}