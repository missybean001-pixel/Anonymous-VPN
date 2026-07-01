package com.anonymousvpn.github

import retrofit2.http.GET
import retrofit2.http.Header

interface GitHubApi {

    @GET("user/repos")
    suspend fun getRepos(
        @Header("Authorization") token: String
    ): List<Repo>
}
