package com.bamsong.app.core.data.datasource

import com.bamsong.app.core.data.network.zoo.entity.ZooContent

interface ZooRemoteSource {
    fun getContent(contentId: String) : Result<ZooContent?>
}

