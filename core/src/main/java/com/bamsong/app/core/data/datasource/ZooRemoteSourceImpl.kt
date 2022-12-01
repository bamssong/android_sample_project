package com.bamsong.app.core.data.datasource

import com.bamsong.app.core.data.network.zoo.entity.ZooContent

class ZooRemoteSourceImpl : ZooRemoteSource {
    override fun getContent(contentId: String): Result<ZooContent?> {
        return Result.success(
            ZooContent(
                zooId = "zoo01",
                zooName = "NEW BAM STORY",
                description = "BLAH BLAH BLAH"
            )
        )
    }
}