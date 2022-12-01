package com.bamsong.app.core.data.network.zoo.api

import com.bamsong.app.core.data.network.zoo.entity.ZooContent
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface ZooContentApi {
    @GET("api/v1/content")
    fun getContent(
        @HeaderMap requestHeaderMap: Map<String, String>
    ): ZooContent

}
