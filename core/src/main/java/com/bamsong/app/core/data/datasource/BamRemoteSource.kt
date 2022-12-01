package com.bamsong.app.core.data.datasource

import com.bamsong.app.core.data.network.bam.entity.BamContent

interface BamRemoteSource {
    fun getContent(contentId: String) : Result<BamContent?>
}

