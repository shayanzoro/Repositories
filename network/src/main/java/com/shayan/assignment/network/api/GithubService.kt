package com.shayan.assignment.network.api

import com.shayan.assignment.network.dto.GithubRepoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @GET("/users/{userName}/repos")
    suspend fun getRepositories(
        @Path("userName") userName: String,
        @Query("page") page: Int,
        @Query("per_page") size: Int,
    ): Response<List<GithubRepoDto>>
}
