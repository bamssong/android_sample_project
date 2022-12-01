package com.bamsong.app.core.data.datasource

import com.bamsong.app.core.data.network.bam.entity.BamContent

class BamRemoteSourceImpl : BamRemoteSource {
    override fun getContent(contentId: String): Result<BamContent?> {
        return Result.success(
            BamContent(
                contentId = "bam01",
                contentName = "NEW BAM STORY",
                contentDescription = "BLAH BLAH BLAH"
            )
        )
    }
}