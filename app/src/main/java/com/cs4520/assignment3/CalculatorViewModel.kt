package com.cs4520.assignment3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    fun calculate (operation: (num1: Double, num2: Double) -> Double, num1: String, num2: String) {
        try {
            val num1Double = num1.toDoubleOrNull() ?: 0.0
            val num2Double = num2.toDoubleOrNull() ?: 0.0
            _result.value = operation(num1Double, num2Double).toString()
        } catch (e: Exception) {
            _result.value = e.message ?: "An error occurred"
        }
    }
}