package com.bamsong.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bamsong.app.core.ui.compose.SampleCard
import com.bamsong.app.core.ui.theme.SampleApplicationTheme
import com.bamsong.app.core.util.Activities
import com.bamsong.app.core.util.intentTo

private const val INDEX_SEARCH = 0
private const val INDEX_DETAIL = 1
private const val INDEX_DETAIL2 = 2
private const val INDEX_DETAIL3 = 3


class ListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleApplicationTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    List { index ->
                        when (index) {
                            INDEX_SEARCH -> {
                                val intent = intentTo(Activities.Search)
                                startActivity(intent)
                            }
                            INDEX_DETAIL -> {
                                val intent = intentTo(Activities.Detail.Default)
                                intent.putExtra(Activities.Detail.EXTRA_CONTENT_ID,"")
                                intent.putExtra(Activities.Detail.EXTRA_TOKEN_ID,"")
                                startActivity(intent)
                            }
                            INDEX_DETAIL2 -> {
                                val intent = intentTo(Activities.Detail.Detail2)
                                intent.putExtra(Activities.Detail.EXTRA_CONTENT_ID,"")
                                intent.putExtra(Activities.Detail.EXTRA_TOKEN_ID,"")
                                startActivity(intent)
                            }
                            INDEX_DETAIL3 -> {
                                val intent = intentTo(Activities.Detail.Detail3)
                                intent.putExtra(Activities.Detail.EXTRA_CONTENT_ID,"")
                                intent.putExtra(Activities.Detail.EXTRA_TOKEN_ID,"")
                                startActivity(intent)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun List(
    onClick: (Int) -> Unit
) {
    Column {
        RowCard("검색하기", color = Color.DarkGray) {
            onClick.invoke(INDEX_SEARCH)
        }
        RowCard("목록(Detail)", color = Color.Cyan) {
            onClick.invoke(INDEX_DETAIL)
        }
        RowCard("목록(Detail2)", color = Color.Magenta) {
            onClick.invoke(INDEX_DETAIL2)
        }
        RowCard("목록(Detail3)", color = Color.Green) {
            onClick.invoke(INDEX_DETAIL3)
        }
    }
}

@Composable
fun RowCard(text: String,
               color: Color = Color.Gray,
               onClick: () -> Unit) {
    Box(modifier = Modifier
        .clickable(onClick = onClick)
        .fillMaxWidth()
        .height(72.dp)
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
    SampleApplicationTheme {
        List { }
    }
}