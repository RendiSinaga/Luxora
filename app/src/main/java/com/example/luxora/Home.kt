package com.example.luxora

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.luxora.animation.AnimatedBackground
import com.example.luxora.data.DummyData
import com.example.luxora.model.Product
import com.example.luxora.ui.theme.DarkGray
import com.example.luxora.ui.theme.LightGray

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf("") }
    val products = DummyData.products

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 0.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Text(
            text = "Luxxora",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "Gaya yang Berkelas, Harga yang Terjangkau",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(20.dp)),
            placeholder = { Text("Search...") },
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Electronics",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            val electronicProducts = products.filter {
                it.category == "Electronics" && (searchText.isEmpty() || it.name.contains(
                    searchText,
                    ignoreCase = true
                ))
            }
            items(electronicProducts) { product ->
                ProductCards(product = product, onClick = { productId ->
                    navController.navigate("detail/product/$productId")
                })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Sport and Fashion",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            val sportAndFashionProducts = products.filter {
                (it.category == "Sport" || it.category == "Fashion") &&
                        (searchText.isEmpty() || it.name.contains(
                            searchText,
                            ignoreCase = true
                        ))
            }
            items(sportAndFashionProducts) { product ->
                ProductCard(product = product, onClick = { productId ->
                    navController.navigate("detail/product/$productId")
                })
            }
        }
    }
}

@Composable
fun ProductCard(product: Product, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(150.dp),
        colors = CardDefaults.cardColors(containerColor = LightGray)
    ) {
        Row(
            modifier = Modifier
                .padding(start = 18.dp, top = 24.dp, bottom = 24.dp, end = 18.dp)
                .fillMaxWidth()
                .height(110.dp),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = product.photo),
                contentDescription = "Image for ${product.name}",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(width = 120.dp, height = 110.dp)
                    .clip(RoundedCornerShape(14.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = product.name,
                    fontSize = 20.sp,
                    color = Color(0xFF333333),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { onClick(product.id) },
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkGray),
                    contentPadding = PaddingValues(horizontal = 3.dp, vertical = 0.dp),
                    modifier = Modifier
                        .width(100.dp)
                        .height(25.dp)
                ) {
                    Text(
                        text = "Lihat Detail",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ProductCards(product: Product, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .padding(8.dp)
            .height(180.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD3D3D3)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = product.photo),
                contentDescription = "Image for ${product.name}",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.name,
                fontSize = 14.sp,
                color = Color(0xFF333333),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(1f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { onClick(product.id) },
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DarkGray),
                contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
                modifier = Modifier
                    .height(25.dp)
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = "Lihat Detail",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        AnimatedBackground()

        HomeScreen(navController = rememberNavController())
    }
}
