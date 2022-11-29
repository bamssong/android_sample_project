package com.bamsong.app.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bamsong.app.core.ui.compose.SampleCard
import com.bamsong.app.core.ui.theme.SampleApplicationTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SampleCard("상세") { }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    SampleApplicationTheme {
        SampleCard("상세") { }
    }
}