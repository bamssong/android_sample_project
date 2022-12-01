package com.bamsong.app.core.data.datasource

import com.bamsong.app.core.data.network.github.api.GitHubService
import com.bamsong.app.core.data.network.github.entity.GithubRepo

class GitHubRemoteSourceImpl( // test retrofit api
    private val gitHubService: GitHubService,
):GitHubRemoteSource {
    override fun getContent(contentId: String): Result<GithubRepo?> {
        val response = gitHubService.listRepos(contentId).execute()
        val data = response.body()
        return if(response.isSuccessful && data != null) {
            Result.success(
                if(data.isNotEmpty()) data.last()
                else null
            )
        } else {
            Result.failure(Throwable(response.errorBody().toString()))
        }
    }
}