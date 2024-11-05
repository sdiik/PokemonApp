package com.example.myapplication.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_favorites")
data class PokemonFavorite(@PrimaryKey val pokemonId: Int)