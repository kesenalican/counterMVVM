package com.alicankesen.sayacmvvm

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    var result = "0"
    fun sum(num1: String, num2: String){
        var num1 = num1.toInt()
        var num2 = num2.toInt()
        result = (num1 + num2).toString()
    }
    fun sub(num1: String, num2: String){
        var num1 = num1.toInt()
        var num2 = num2.toInt()
        result = (num1 - num2).toString()
    }
    fun multiply(num1: String, num2: String){
        var num1 = num1.toInt()
        var num2 = num2.toInt()
        result = (num1 / num2).toString()
    }
    fun divide(num1: String, num2: String){
        var num1 = num1.toInt()
        var num2 = num2.toInt()
        result = (num1 * num2).toString()
    }
}