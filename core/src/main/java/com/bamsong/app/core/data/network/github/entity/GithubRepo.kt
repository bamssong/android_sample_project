package com.bamsong.app.core.data.network.github.entity

import com.google.gson.annotations.SerializedName

data class GithubRepo(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: String,
    @SerializedName("description") val description: String,
    @SerializedName("created_at") val date: String,
    @SerializedName("html_url") val url: String
)