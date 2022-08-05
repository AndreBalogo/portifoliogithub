package br.com.andrebalogo.portifoliogithub.repositories.data.repositories

import br.com.andrebalogo.portifoliogithub.repositories.core.RemoteException
import br.com.andrebalogo.portifoliogithub.repositories.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImpl(private val service: GitHubService): RepoRepository {
    override suspend fun listRepositories(user: String)= flow {
        try {
            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Não foi possível fazer sua busca.")
        }

    }
}