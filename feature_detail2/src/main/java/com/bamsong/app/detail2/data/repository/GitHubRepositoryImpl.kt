package com.bamsong.app.detail2.data.repository

import com.bamsong.app.core.data.datasource.GitHubRemoteSource
import com.bamsong.app.core.data.mapper.ContentMapper
import com.bamsong.app.core.domain.entity.Content
import com.bamsong.app.core.domain.repository.ContentRepository
import timber.log.Timber

class GitHubRepositoryImpl(
    private val gitHubRemoteSource: GitHubRemoteSource
) : ContentRepository {
    override fun getContent(type: String, contentId: String): Content {
        val response = gitHubRemoteSource.getContent(contentId)
        return if(response.isSuccess) {
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
    }
}