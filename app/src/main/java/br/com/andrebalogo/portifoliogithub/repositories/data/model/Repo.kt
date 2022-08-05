package br.com.andrebalogo.portifoliogithub.repositories.data.model

data class Repo (
    val id: Long,
    val name: String,
    val owner: Owner,
    val htmlURL: String,
    val description: String,
    val stargazersCount: Long,
    val watchersCount: Long,
    val language: String
)
