package com.bamsong.app.detail3.data.datasource

import com.bamsong.app.core.data.network.github.api.GitHubService
import com.bamsong.app.core.data.network.github.entity.GithubRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GitHubRemoteSourceImpl(
    private val gitHubService: GitHubService,
):GitHubRemoteSource {
    override suspend fun getContent(contentId: String): Flow<GithubRepo?> {
        return flow {
            val listRepos = gitHubService.listReposFlow(contentId)
            if(listRepos == null) {
                emit(null)
            } else {
                emit(listRepos.last())
            }
        }
    }
}