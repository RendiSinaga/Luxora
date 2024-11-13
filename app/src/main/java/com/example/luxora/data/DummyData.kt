package com.example.luxora.data

import com.example.luxora.R
import com.example.luxora.model.Game
import com.example.luxora.model.Product

object DummyData {
    val products = listOf(
        Product(id = 1, name = "Bola Kaki Adidas", price = 120.0, category = "Sport", rating = 4.4, photo = R.drawable.bola ),
        Product(id = 2, name = "Raket Anti Patah", price = 85.0, category = "Sport", rating = 4.6, photo = R.drawable.raket),
        Product(id = 3, name = "Basket Gacor", price = 100.0, category = "Sport", rating = 4.2, photo = R.drawable.basket),
        Product(id = 4, name = "Sepatu Bekas Cr", price = 10000.0, category = "Sport", rating = 3.9, photo = R.drawable.sepatu),
        Product(id = 5, name = "Tennis Juara", price = 999.0, category = "Sports", rating = 4.8, photo = R.drawable.tennis),

        Product(id = 6, name = "Jas Bapak", price = 20.0, category = "Fashion", rating = 4.1, photo = R.drawable.jas),
        Product(id = 7, name = "Celana Panjang", price = 45.0, category = "Fashion", rating = 4.3, photo = R.drawable.celana),
        Product(id = 8, name = "Baju Bekas Messi", price = 10000.0, category = "Fashion", rating = 4.0, photo = R.drawable.mesi),
        Product(id = 9, name = "Dress Wanita", price = 10000.0, category = "Fashion", rating = 4.5, photo = R.drawable.dress),
        Product(id = 10, name = "Jam Gucci", price = 5999.0, category = "Fashion", rating = 4.7, photo = R.drawable.jam),

        Product(id = 11, name = "Iphone 14", price = 799.0, category = "Electronics", rating = 4.9, photo = R.drawable.iphone),
        Product(id = 12, name = "JBL", price = 499.0, category = "Electronics", rating = 4.6, photo = R.drawable.headphone),
        Product(id = 13, name = "Samsung S24 Ultra", price = 799.0, category = "Electronics", rating = 4.7, photo = R.drawable.samsung),
        Product(id = 14, name = "Redmi 13", price = 699.0, category = "Electronics", rating = 4.4, photo = R.drawable.xiaomi),
        Product(id = 15, name = "Iphone 16", price = 999.0, category = "Electronics", rating = 4.8, photo = R.drawable.ip),
        Product(id = 16, name = "Laptop Rog Gaming", price = 2999.0, category = "Electronics", rating = 4.8, photo = R.drawable.rog),
        Product(id = 17, name = "Laptop Victus Gaming", price = 1999.0, category = "Electronics", rating = 4.5, photo = R.drawable.victus),
        Product(id = 18, name = "Mouse Gaming", price = 499.0, category = "Electronics", rating = 4.3, photo = R.drawable.mouse),
        Product(id = 19, name = "Playstation 5", price = 1999.0, category = "Electronics", rating = 4.9, photo = R.drawable.ps5),
        Product(id = 20, name = "Headphone Gaming", price = 399.0, category = "Electronics", rating = 4.5, photo = R.drawable.set),
    )

    val games = listOf(
        Game(id = 1, name = "PUBG", genre = "Battle Royale, Shooter", rating = 4.5, play = 100_000_000, photo = R.drawable.pubg),
        Game(id = 2, name = "Mobile Legend", genre = "MOBA, Strategy", rating = 4.2, play = 500_000_000, photo = R.drawable.ml),
        Game(id = 3, name = "Valorant", genre = "FPS, Shooter, Strategy", rating = 4.8, play = 25_000_000, photo = R.drawable.valorant),
        Game(id = 4, name = "Genshin Impact", genre = "Action RPG, Open World", rating = 4.9, play = 60_000_000, photo = R.drawable.genshin),
        Game(id = 5, name = "Fortnite", genre = "Battle Royale, Shooter", rating = 4.7, play = 350_000_000, photo = R.drawable.fortnite),
        Game(id = 6, name = "Minecraft", genre = "Sandbox, Adventure", rating = 4.8, play = 238_000_000, photo = R.drawable.minecraft),
        Game(id = 7, name = "Clash of Clans", genre = "Strategy, Base Building", rating = 4.9, play = 500_000_000, photo = R.drawable.coc),
        Game(id = 8, name = "Candy Crush", genre = "Puzzle", rating = 4.8, play = 273_000_000, photo = R.drawable.candy),
        Game(id = 9, name = "Fifa 24", genre = "Sports, Simulation", rating = 4.7, play = 15_000_000, photo = R.drawable.fifa),
        Game(id = 10, name = "Clash Royale", genre = "Strategy, Card Game", rating = 4.7, play = 100_000_000, photo = R.drawable.royale),
        Game(id = 11, name = "Black Myth Wukong", genre = "Action RPG, Fantasy", rating = 4.9, play = 5_000_000, photo = R.drawable.wukong),
        Game(id = 12, name = "Roblox", genre = "Sandbox, Social Platform", rating = 4.6, play = 200_000_000, photo = R.drawable.roblox)
    )


}