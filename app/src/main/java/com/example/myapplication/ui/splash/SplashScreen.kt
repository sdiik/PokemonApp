package com.example.myapplication.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.ui.PokemonAppDestinations
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import okhttp3.internal.wait

@Composable
fun SplashScreen(navController: NavHostController){
    LaunchedEffect(key1 = true) {
        delay(3000L)
        navController.popBackStack()
        navController.navigate(PokemonAppDestinations.HOME_ROUTE)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.White).fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painterResource(R.drawable.ic_pokemon_logo),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth(0.3f)
            )
            Column(
                modifier = Modifier.padding(top = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "POKEMON",
                    fontSize = 24.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "find the best one",
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashReview(){
    val navController = rememberNavController()
    MyApplicationTheme {
        SplashScreen(navController = navController)
    }
}