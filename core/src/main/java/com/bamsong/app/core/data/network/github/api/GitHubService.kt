package com.bamsong.app.core.data.network.github.api

import com.bamsong.app.core.data.network.github.entity.GithubRepo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubService {
    companion object {
        fun create(): GitHubService = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY }
                ).build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubService::class.java)
    }

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Call<List<GithubRepo>>
}
