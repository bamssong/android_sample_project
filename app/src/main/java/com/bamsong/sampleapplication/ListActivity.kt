package com.bamsong.sampleapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bamsong.sampleapplication.ui.theme.SampleApplicationTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SampleCard("목록", color = Color.Green) {
                        //nothing.
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ListPreview() {
    SampleApplicationTheme {
        SampleCard("목록!!", color = Color.Green) { }
    }
}