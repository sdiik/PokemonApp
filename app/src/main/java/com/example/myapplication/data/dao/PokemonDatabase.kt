package com.example.myapplication.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.models.PokemonFavorite

@Database(entities = [PokemonFavorite::class], version = 1, exportSchema = false)
abstract  class PokemonDatabase: RoomDatabase() {
    abstract fun pokemonDeo(): PokemonDao
}