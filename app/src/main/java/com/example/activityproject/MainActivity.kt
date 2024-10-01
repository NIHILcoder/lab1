package com.example.activityproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.example.activityproject.ui.theme.ActivityProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivityProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    val context = LocalContext.current  // Получаем текущий контекст

    Button(onClick = {
        val intent = Intent(context, SecondActivity::class.java).apply {
            putExtra("param", "Твоя фамилия") // передача параметра
        }
        context.startActivity(intent)
    }, modifier = modifier.padding(16.dp)) {
        Text(text = "Перейти на вторую активность")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ActivityProjectTheme {
        MainContent()
    }
}
// Типо 1 лаба