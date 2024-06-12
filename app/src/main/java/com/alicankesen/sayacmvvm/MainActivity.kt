package com.alicankesen.sayacmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alicankesen.sayacmvvm.ui.theme.SayacMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayacMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterPage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CounterPage() {
    var result by remember {
        mutableStateOf("0")
    }
    var num1 by remember {
        mutableStateOf("")
    }
    var num2 by remember {
        mutableStateOf("")
    }

    val viewModel: CounterViewModel = viewModel()


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = result)
        TextField(value = num1, onValueChange = { num1 = it })
        TextField(value = num2, onValueChange = { num2 = it })
        CommonButton(
            onClick = {
                viewModel.sum(num1, num2)
                result = viewModel.result
            },
            text = "Topla",
        )
        CommonButton(
            onClick = {
                viewModel.sub(num1, num2)
                result = viewModel.result
            },
            text = "Çıkar",
        )
        CommonButton(
            onClick = {
                viewModel.multiply(num1, num2)
                result = viewModel.result
            },
            text = "Çarp",
        )
        CommonButton(
            onClick = {
                viewModel.divide(num1, num2)
                result = viewModel.result
            },
            text = "Böl",
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SayacMVVMTheme {
        CounterPage()
    }
}