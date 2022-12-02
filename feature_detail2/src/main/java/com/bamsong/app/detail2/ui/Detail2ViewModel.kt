package com.bamsong.app.detail2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bamsong.app.core.domain.entity.Content
import com.bamsong.app.core.domain.usecase.ContentUseCase
import com.bamsong.app.core.util.AppExecutors

class Detail2ViewModel(
    private val contentUseCase: ContentUseCase
): ViewModel() {
    private val executors = AppExecutors()
    private var isExecute = false

    private val _content = MutableLiveData<Content>()
    val contentLiveData: LiveData<Content> = _content

    fun getGitHubContentId(githubContentId : String) {
        if(isExecute) return
        executors.networkIO().execute {
            isExecute = true
            val data = contentUseCase.getContent("", githubContentId)
            updateContent(data)
            isExecute = false
        }
    }

    private fun updateContent(content: Content) {
        executors.mainThread().execute {
            _content.value = content
        }
    }
}