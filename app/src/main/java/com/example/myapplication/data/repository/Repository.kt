package com.example.myapplication.data.repository

import com.example.myapplication.data.models.ApiResponse
import com.example.myapplication.data.models.Pokemon
import com.example.myapplication.data.models.PokemonDetails
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getPokemonList(limit: Int, offsite: Int): Flow<ApiResponse<List<PokemonDetails>>>
    fun getSavedPokemon(savePokemon: Set<Int>): Flow<ApiResponse<List<PokemonDetails>>>
}