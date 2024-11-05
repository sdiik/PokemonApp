package com.example.myapplication.data.repository

import com.example.myapplication.data.models.PokemonFavorite
import kotlinx.coroutines.flow.Flow

interface OfflinePokemonRepository {
    suspend fun addFavorite(pokemonId: Int)
    suspend fun removeFavorite(pokemonId: Int)
    fun getAllPokemon(): Flow<List<PokemonFavorite>>
}