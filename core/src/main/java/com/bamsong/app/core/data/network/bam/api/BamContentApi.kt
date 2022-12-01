package com.bamsong.app.core.data.network.bam.api

import com.bamsong.app.core.data.network.bam.entity.BamContent
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface BamContentApi {
    @GET("api/v1/content")
    fun getContent(
        @HeaderMap requestHeaderMap: Map<String, String>
    ): BamContent

}
