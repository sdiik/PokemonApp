package com.example.myapplication.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.backgroundColor

@Composable
fun FavouritePokemonGrid(
    onPokemonItemClicked: () -> Unit,
    viewModel: HomeViewModel
) {
    val favoritePokemonState by viewModel.favoritePokemon.collectAsState()
    val reversedPokemonState = favoritePokemonState.reversed()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentPadding = PaddingValues(top = 20.dp, start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(reversedPokemonState.size) { index: Int ->
            PokemonGridItem(
                pokemon = reversedPokemonState[index],
                onPokemonItemClicked = onPokemonItemClicked,
                viewModel = viewModel
            )
        }
    }
}