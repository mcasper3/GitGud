package io.github.mcasper3.gitgud.login

import com.squareup.moshi.Json

class LoginRequest(
    @Json(name = "client_id") val clientId: String,
    @Json(name = "client_secret") val clientSecret: String,
    @Json(name = "code") val code: String
)
