package com.bamsong.app.detail2.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bamsong.app.core.data.datasource.GitHubRemoteSourceImpl
import com.bamsong.app.core.data.network.github.api.GitHubService
import com.bamsong.app.core.domain.usecase.ContentUseCaseImpl
import com.bamsong.app.core.ui.theme.SampleApplicationTheme
import com.bamsong.app.detail2.data.repository.GitHubRepositoryImpl
import timber.log.Timber

class Detail2Activity : ComponentActivity() {
    private val viewModel: Detail2ViewModel
    init {
        val source = GitHubRemoteSourceImpl(GitHubService.create())
        val repository = GitHubRepositoryImpl(source)
        viewModel = Detail2ViewModel(ContentUseCaseImpl(repository))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.contentLiveData.observe(this) { content ->
            Timber.d("content : $content")
        }

        viewModel.getGitHubContentId("bamssong")

        setContent {
            SampleApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Detail2")
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleApplicationTheme {
        Greeting("Detail2")
    }
}