package com.bamsong.app.detail3.data.repository

import com.bamsong.app.core.data.mapper.ContentMapper
import com.bamsong.app.core.domain.entity.Content
import com.bamsong.app.detail3.data.datasource.GitHubRemoteSource
import com.bamsong.app.detail3.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GitHubRepositoryImpl(
    private val gitHobRemoteSource: GitHubRemoteSource
) : ContentRepository {
    override suspend fun getContent(type: String, contentId: String): Flow<Content> {
        return gitHobRemoteSource.getContent(contentId).map { content ->
            if(content != null) {
                ContentMapper.gitHubRepoToContent(content)
            } else {
                ContentMapper.emptyContent()
            }
        }
    }
}