package io.github.mcasper3.gitgud.login

import retrofit2.http.POST
import retrofit2.http.Path

interface LoginService {
    @POST("/login/oauth/access_token")
    fun logIn(
        @Path("clientId") clientId: String,
        @Path("client_secret") secret: String,
        @Path("code") code: String
    )
}
