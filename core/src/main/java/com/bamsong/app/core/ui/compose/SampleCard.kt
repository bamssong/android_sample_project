package com.bamsong.app.core.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SampleCard(text: String,
               color: Color = Color.Gray,
               onClick: () -> Unit) {
    Box(modifier = Modifier
        .clickable(onClick = onClick)
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
fun ListPreview() {
    SampleCard("목록!!", color = Color.Green) { }
}
