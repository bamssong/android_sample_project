package com.bamsong.app.detail3.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bamsong.app.core.domain.entity.Content
import com.bamsong.app.detail3.domain.usecase.ContentUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import timber.log.Timber

class Detail3ViewModel(
    private val contentUseCase: ContentUseCase
) : ViewModel() {
    private val _content = MutableLiveData<Content>()
    val contentLiveData: LiveData<Content> = _content

    fun getGitHubContentId(githubContentId: String) {
        viewModelScope.launch {
            contentUseCase.getContent("", githubContentId)
                .flowOn(Dispatchers.IO)
                .catch {
                    //handle exception
                    Timber.e("error $this")
                }
                .collect { content ->
                    updateContent(content)
                }
        }
    }

    private fun updateContent(content: Content) {
        _content.value = content
    }
}