package com.bamsong.app.core.data.mapper

import com.bamsong.app.core.data.network.bam.entity.BamContent
import com.bamsong.app.core.data.network.github.entity.GithubRepo
import com.bamsong.app.core.data.network.zoo.entity.ZooContent
import com.bamsong.app.core.domain.entity.Content

object ContentMapper {
    fun emptyContent() = Content("", "", "", "")

    fun gitHubRepoToContent(githubRepo: GithubRepo) = Content(
        type = "git",
        id = githubRepo.id,
        name = githubRepo.name,
        desc = githubRepo.description.take(100)
    )

    fun bamContentToContent(bamContent: BamContent) = Content(
        type = "bam",
        id = bamContent.contentId,
        name = bamContent.contentName,
        desc = bamContent.contentDescription
    )

    fun zooContentToContent(zooContent: ZooContent) = Content(
        type = "zoo",
        id = zooContent.zooId,
        name = zooContent.zooName,
        desc = zooContent.description
    )
}