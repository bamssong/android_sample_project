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
import com.bamsong.app.core.data.datasource.GitHubRemoteSourceImpl
import com.bamsong.app.core.data.mapper.ContentMapper
import com.bamsong.app.core.data.network.github.api.GitHubService
import com.bamsong.app.core.domain.entity.Content
import com.bamsong.app.core.ui.compose.SampleCard
import com.bamsong.app.core.ui.theme.SampleApplicationTheme
import com.bamsong.app.core.util.AppExecutors
import timber.log.Timber

class DetailActivity : ComponentActivity() {
    private val executors = AppExecutors()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        executors.networkIO().execute {
            val response = GitHubRemoteSourceImpl(GitHubService.create()).getContent("bamssong")
            val content = if(response.isSuccess) {
                val data = response.getOrNull()
                Timber.d("response data : $data")
                if(data != null) {
                    ContentMapper.gitHubRepoToContent(data)
                } else {
                    ContentMapper.emptyContent()
                }
            } else {
                Timber.e("response data : ${response.exceptionOrNull()}")
                ContentMapper.emptyContent()
            }
            updateContent(content)
        }

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

    private fun updateContent(content: Content) {
        executors.mainThread().execute {
            Timber.d("content : $content")
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