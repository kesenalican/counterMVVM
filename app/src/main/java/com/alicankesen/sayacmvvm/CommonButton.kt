package com.alicankesen.sayacmvvm

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CommonButton(onClick : () -> Unit, text: String){
    Button(onClick =onClick) {
        Text(text = text)
    }
}