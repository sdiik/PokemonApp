package com.example.myapplication.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun PokemonApp() {
    MyApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            PokemonNavGrap()
        }
    }
}