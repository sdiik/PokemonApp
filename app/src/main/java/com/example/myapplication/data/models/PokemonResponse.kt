package com.example.myapplication.data.models

import com.google.gson.annotations.SerializedName

data class PokemonResponse(@SerializedName("result") val result: List<Pokemon>)