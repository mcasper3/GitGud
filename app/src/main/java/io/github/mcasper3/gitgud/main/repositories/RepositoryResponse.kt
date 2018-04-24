package io.github.mcasper3.gitgud.main.repositories

import com.squareup.moshi.Json

class ApiRepository(
    val id: Long,
    val name: String,
    @Json(name = "full_name") val fullName: String,
    val description: String?,
    val private: Boolean,
    @Json(name = "fork") val isFork: Boolean,
    val url: String?,
    val language: String?,
    @Json(name = "forks_count") val forksCount: Int,
    @Json(name = "stargazers_count") val starsCount: Int,
    @Json(name = "watchers_count") val watchersCount: Int
)
