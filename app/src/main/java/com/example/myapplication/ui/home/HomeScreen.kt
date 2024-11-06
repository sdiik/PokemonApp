package com.example.myapplication.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.ui.PokemonAppDestinations
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.textColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel) {
    var state by remember { mutableIntStateOf(0) }
    val pokemonGridState = rememberLazyGridState()
    val favoritePokemonState = viewModel.favoritePokemon.collectAsState()

    Scaffold(
        topBar = {
            Box {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = textColor
                    ),
                    title = {
                        Row {
                            Image(
                                painter = painterResource(R.drawable.ic_pokemon_logo),
                                contentDescription = "",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.width(width = 24.dp)
                                )
                            Spacer(modifier = Modifier.width(width = 8.dp))
                            Text(
                                text = "pokedev",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .align(Alignment.BottomCenter)
                        .background(
                            color = Color.Black.copy(alpha = 0.1f)
                        )
                )
            }
        },
        content = { innerPadding ->
            Surface(modifier = Modifier.padding(innerPadding)) {
                Column {
                    HomeTabRow(
                        state = state, onClick = {
                            state = it
                        }, favoriteCount = favoritePokemonState.value.size
                    )
                    when (state) {
                        0 -> PokemonGrid(
                            viewModel = viewModel,
                            lazyGridState = pokemonGridState,
                            onPokemonItemClicked = {
                                navController.navigate(PokemonAppDestinations.POKEMON_DETAIL)
                            }
                        )
                        1 -> FavouritePokemonGrid(
                            viewModel = viewModel,
                            onPokemonItemClicked = {
                                navController.navigate(PokemonAppDestinations.POKEMON_DETAIL)
                            }
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomePreview(viewModel: HomeViewModel = hiltViewModel()) {
    val navController = rememberNavController()
    MyApplicationTheme {
        HomeScreen(navController = navController, viewModel)
    }
}
