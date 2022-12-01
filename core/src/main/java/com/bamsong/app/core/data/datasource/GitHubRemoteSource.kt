package com.bamsong.app.core.data.datasource

import com.bamsong.app.core.data.network.github.entity.GithubRepo

interface GitHubRemoteSource {
    fun getContent(contentId: String) : Result<GithubRepo?>
}