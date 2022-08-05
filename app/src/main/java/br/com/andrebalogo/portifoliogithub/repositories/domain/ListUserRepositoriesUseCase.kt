package br.com.andrebalogo.portifoliogithub.repositories.domain

import br.com.andrebalogo.portifoliogithub.repositories.core.UseCase
import br.com.andrebalogo.portifoliogithub.repositories.data.model.Repo
import br.com.andrebalogo.portifoliogithub.repositories.data.repositories.RepoRepository
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase(
    private val repository: RepoRepository
    ) : UseCase<String, List<Repo>>() {
    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }

}