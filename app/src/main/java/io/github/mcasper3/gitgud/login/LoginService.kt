package io.github.mcasper3.gitgud.login

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface LoginService {
    @POST
    fun logIn(@Url loginUrl: String, @Body request: LoginRequest): Observable<LoginResponse>
}
