package com.example.myapplication.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.myapplication.data.models.PokemonDetails
import com.example.myapplication.utils.calculateAvgPower

@Composable
fun StatList(pokemon: PokemonDetails) {
    val stats = pokemon.stats ?: emptyList()

    val statItems = stats.map {
        BaseStatItem(
            title = it.statDetail.name,
            statValue = it.baseStat
        )
    } + BaseStatItem(
        title = "Avg. Power",
        statValue = calculateAvgPower(stats).toInt()
    )

    Column {
        statItems.forEach { item ->
            item
        }
    }

}