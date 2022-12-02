package com.bamsong.app.detail3.data.datasource

import com.bamsong.app.core.data.network.github.entity.GithubRepo
import kotlinx.coroutines.flow.Flow

interface GitHubRemoteSource {
    suspend fun getContent(contentId: String) : Flow<GithubRepo?>
}