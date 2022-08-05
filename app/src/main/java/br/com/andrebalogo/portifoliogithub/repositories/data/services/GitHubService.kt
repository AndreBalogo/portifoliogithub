package br.com.andrebalogo.portifoliogithub.repositories.data.services

import br.com.andrebalogo.portifoliogithub.repositories.data.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepositories(@Path("user") user: String?): List<Repo>

}