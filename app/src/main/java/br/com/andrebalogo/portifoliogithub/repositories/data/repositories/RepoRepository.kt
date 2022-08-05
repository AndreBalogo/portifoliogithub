package br.com.andrebalogo.portifoliogithub.repositories.data.repositories

import br.com.andrebalogo.portifoliogithub.repositories.data.model.Repo
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun listRepositories(user: String): Flow<List<Repo>>
}