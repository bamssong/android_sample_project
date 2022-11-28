package com.bamsong.sampleapplication

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bamsong.sampleapplication.ui.theme.SampleApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SampleCard("메인 화면 입니다.")
                }
            }
        }
    }
}

@Composable
fun SampleCard(text: String, color: Color = Color.Gray) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleApplicationTheme {
        SampleCard("Android")
    }
}