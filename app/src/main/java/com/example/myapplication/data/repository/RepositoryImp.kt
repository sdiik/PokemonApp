package com.example.myapplication.data.repository

import android.util.Log
import com.example.myapplication.data.models.ApiResponse
import com.example.myapplication.data.models.Pokemon
import com.example.myapplication.data.models.PokemonDetails
import com.example.myapplication.data.service.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val apiService: ApiService
): Repository {
    override fun getPokemonList(limit: Int, offsite: Int): Flow<ApiResponse<List<PokemonDetails>>> = flow {
        try {
            val response = apiService.getPokemonList(limit, offsite)
            Log.d("RESPONSE API", "data limit =======${limit}")
            Log.d("RESPONSE API", "data offset =======${offsite}")
            Log.d("RESPONSE API", "data =======${response}")
            val detailPokemonList = mutableListOf<PokemonDetails>()
            response.result.forEach{ pokemon: Pokemon ->
                val pokemonDetails = apiService.getPokemonDetail(pokemon.url)
                Log.d("POKEMONDETAIL", "====================${pokemonDetails}")
                detailPokemonList.add(pokemonDetails)
            }
            emit(ApiResponse.Success(detailPokemonList))
        } catch(e: Exception) {
            emit(ApiResponse.Error("An error occurred: ${e.localizedMessage}"))
        }
    }

    override fun getSavedPokemon(savePokemon: Set<Int>): Flow<ApiResponse<List<PokemonDetails>>> = flow {
        try {
            val detailPokemonList = mutableListOf<PokemonDetails>()
            savePokemon.forEach { pokemonId: Int ->
                val pokemonDetails = apiService.getPokemonDetail("https://pokeapi.co/api/v2/pokemon/${pokemonId}")
                detailPokemonList.add(pokemonDetails)
            }
            emit(ApiResponse.Success(detailPokemonList))
        }catch (e: Exception) {
            emit(ApiResponse.Error("An error occurred: ${e.localizedMessage}"))
        }
    }
}