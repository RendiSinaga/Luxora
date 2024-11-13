package com.example.luxora

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.luxora.animation.AnimatedBackground
import com.example.luxora.data.DummyData
import com.example.luxora.ui.theme.Gunmetal
import com.example.luxora.ui.theme.LightGray
import com.example.luxora.ui.theme.LuxoraTheme
import com.example.luxora.ui.theme.SilverDark

@Composable
fun DetailScreen(
    id: Int,
    itemType: String,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val product = if (itemType == "product") DummyData.products.find { it.id == id } else null
    val game = if (itemType == "game") DummyData.games.find { it.id == id } else null

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        when {
            product != null -> {
                Image(
                    painter = painterResource(id = product.photo),
                    contentDescription = "Image for ${product.name}",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(250.dp)
                        .padding(16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = product.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                DetailCard(
                    title = "Product Details", data = mapOf(
                        "Price" to product.price.toString(),
                        "Category" to product.category,
                        "Rating" to product.rating.toString()
                    )
                )
            }

            game != null -> {
                Image(
                    painter = painterResource(id = game.photo),
                    contentDescription = "Image for ${game.name}",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(250.dp)
                        .padding(16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = game.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                DetailCard(
                    title = "Game Details", data = mapOf(
                        "Genre" to game.genre,
                        "Rating" to game.rating.toString(),
                        "Play Count" to game.play.toString()
                    )
                )
            }

            else -> {
                Text(
                    text = "Item not found",
                    textAlign = TextAlign.Center,
                    fontSize = 36.sp,
                    color = Color.Red,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
private fun DetailCard(title: String, data: Map<String, String>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                fontSize = 20.sp,
                color = SilverDark,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            data.forEach { (label, value) ->
                DetailInfoRow(label = label, value = value)
            }
        }
    }
}

@Composable
private fun DetailInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$label:",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Gunmetal
        )
        Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        AnimatedBackground()

        val navController = rememberNavController()
        LuxoraTheme {
            DetailScreen(
                id = 1,
                itemType = "Product",
                navController = navController,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

