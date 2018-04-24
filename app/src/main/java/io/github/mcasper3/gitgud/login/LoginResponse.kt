package io.github.mcasper3.gitgud.login

import com.squareup.moshi.Json

class LoginResponse(
    @Json(name = "access_token") val accessToken: String,
    @Json(name = "token_type") val tokenType: String
)
