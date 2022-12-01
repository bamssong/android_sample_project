package com.bamsong.app.core.data.repository

import com.bamsong.app.core.data.datasource.BamRemoteSource
import com.bamsong.app.core.data.datasource.GitHubRemoteSource
import com.bamsong.app.core.data.datasource.ZooRemoteSource
import com.bamsong.app.core.data.mapper.ContentMapper
import com.bamsong.app.core.domain.entity.Content
import com.bamsong.app.core.domain.entity.emptyContent
import com.bamsong.app.core.domain.repository.ContentRepository

class ContentRepositoryImpl(
    private val gitHubRemoteSource: GitHubRemoteSource,
    private val bamRemoteSource: BamRemoteSource,
    private val zooRemoteSource: ZooRemoteSource,
) : ContentRepository {
    override fun getContent(type: String, contentId: String): Content {
        return when (type) {
            "git" -> {
                val response = gitHubRemoteSource.getContent(contentId)
                response.getOrNull()?.run {
                    ContentMapper.gitHubRepoToContent(this)
                } ?: emptyContent()
            }
            "bam" -> {
                val response = bamRemoteSource.getContent(contentId)
                response.getOrNull()?.run {
                    ContentMapper.bamContentToContent(this)
                } ?: emptyContent()
            }
            "zoo" -> {
                val response = zooRemoteSource.getContent(contentId)
                response.getOrNull()?.run {
                    ContentMapper.zooContentToContent(this)
                } ?: emptyContent()
            }
            else -> throw Throwable("not support type")
        }
    }
}