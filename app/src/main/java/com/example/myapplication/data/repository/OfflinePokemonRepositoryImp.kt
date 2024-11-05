package com.example.myapplication.data.repository

import com.example.myapplication.data.dao.PokemonDao
import com.example.myapplication.data.models.PokemonFavorite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OfflinePokemonRepositoryImp(private val pokemonFavoriteDeo: PokemonDao): OfflinePokemonRepository {
    override suspend fun addFavorite(pokemonId: Int) {
        pokemonFavoriteDeo.insertPokemon(PokemonFavorite(pokemonId))
    }

    override suspend fun removeFavorite(pokemonId: Int) {
        pokemonFavoriteDeo.removePokemon(pokemonId)
    }

    override fun getAllPokemon(): Flow<List<PokemonFavorite>> = flow {
        emit(pokemonFavoriteDeo.getAllPokemons())
    }
}