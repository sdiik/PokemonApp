package com.example.myapplication.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.data.models.PokemonDetails
import com.example.myapplication.ui.theme.textColor
import com.example.myapplication.utils.convertPokemonTypesToString
import com.example.myapplication.utils.convertToIdHash
import com.example.myapplication.utils.getPokemonImageBackgroundColor
import java.util.Locale

@Composable
fun TitleSection(pokemon: PokemonDetails) {
    Box(
        modifier = Modifier
            .height(height = 200.dp)
            .fillMaxWidth()
            .background(
                getPokemonImageBackgroundColor(
                    pokemon.name.toString().first().toString()
                )
            ),
    ) {
        Row {
            Column(
                modifier = Modifier
                    .padding(start = 15.dp, bottom = 10.dp, top = 10.dp)
                    .weight(1f)
            ) {
                Text(
                    text = pokemon.name.toString().replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.ROOT
                        ) else it.toString()
                    },
                    fontSize = 32.sp,
                    fontWeight = FontWeight.W700,
                    color = textColor
                )
                Text(
                    text = convertPokemonTypesToString(pokemon.types ?: emptyList()),
                    fontSize = 16.sp,
                    color = textColor,
                    fontWeight = FontWeight.W400,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(
                    Modifier
                        .weight(1f)
                        .background(Color.LightGray)
                )
                Text(
                    text = convertToIdHash(pokemon.id ?: 1),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    color = textColor
                )
            }
            Box(
                modifier = Modifier.height(200.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .size(176.dp)
                        .align(Alignment.BottomEnd),
                    colorFilter = ColorFilter.tint(
                        getPokemonImageBackgroundColor(
                            pokemon.name.toString().first().toString()
                        )
                    )
                )
                AsyncImage(
                    modifier = Modifier
                        .height(125.dp)
                        .width(136.dp),
                    model = pokemon.sprites?.other?.officialArtWork?.frontDefault,
                    contentScale = ContentScale.Crop,
                    contentDescription = "Pokemon Image"
                )
            }
        }
    }
}