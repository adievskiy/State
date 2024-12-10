package com.example.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isEnglish by rememberSaveable { mutableStateOf(false) }
            val products = if (!isEnglish) {
                listOf("Яйца", "Хлеб", "Помидоры", "Масло", "Молоко")
            } else {
                listOf("Eggs", "Bread", "Tomatoes", "Butter", "Milk")
            }
            Surface(Modifier.padding(top = 45.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)) {
                Column {
                    Header("Список продуктов")
                    for (product in products) {
                        ProductText(product)
                    }
                    Text(
                        text = if (isEnglish) "Switch to English" else "Переключить на русский",
                        textAlign = TextAlign.Center,
                        fontSize = 22.sp,
                        color = Color.Black,
                        modifier = Modifier.clickable(onClick = { isEnglish = !isEnglish })
                    )
                }
            }
        }
    }
}

@Composable
fun Header(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .border(width = 3.dp, color = Color.Black)
            .background(Color.DarkGray)
            .fillMaxWidth()
    ) {
        Text(text = text, textAlign = TextAlign.Center, fontSize = 28.sp, color = Color.White)
    }
}

@Composable
fun ProductText(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .border(width = 3.dp, color = Color.Black)
            .background(Color.LightGray)
            .fillMaxWidth()
    ) {
        Text(text = text, textAlign = TextAlign.Center, fontSize = 22.sp, color = Color.White)
    }
}