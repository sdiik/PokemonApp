package com.example.myapplication.data.service

import com.example.myapplication.data.models.PokemonDetails
import com.example.myapplication.data.models.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @GET(Constants.pokemon)
    suspend fun getPokemonList(
        @Query("limit") limit: Int, @Query("offset") offset: Int
    ): PokemonResponse

    @GET
    suspend fun getPokemonDetail(@Url url: String): PokemonDetails
}