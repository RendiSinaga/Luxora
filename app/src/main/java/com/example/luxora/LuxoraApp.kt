package com.example.luxora

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.luxora.animation.AnimatedBackground
import com.example.luxora.navigation.NavigationItem
import com.example.luxora.navigation.Routes
import com.example.luxora.ui.theme.LuxoraTheme

@Composable
fun LuxoraApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val title = when (currentRoute) {
        Routes.HOME -> "Home"
        Routes.GAMES -> "Games"
        Routes.ABOUT -> "About"
        "detail/{itemType}/{itemId}" -> "Detail"
        else -> "Luxxora"
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AnimatedBackground()

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.systemBars),
            topBar = {
                TopBar(
                    title = title,
                    showBackButton = currentRoute == "detail/{itemType}/{itemId}",
                    onBackPressed = { navController.popBackStack() }
                )
            },
            bottomBar = { BottomBar(navController) },
            containerColor = Color.Transparent
        ) { contentPadding ->
            NavHost(
                navController = navController,
                startDestination = Routes.HOME,
                modifier = modifier.padding(contentPadding)
            ) {
                composable(Routes.HOME) {
                    HomeScreen(navController = navController)
                }
                composable(Routes.GAMES) {
                    GamesScreen(navController = navController)
                }
                composable(Routes.ABOUT) {
                    AboutScreen()
                }
                composable("detail/{itemType}/{itemId}") { backStackEntry ->
                    val itemType = backStackEntry.arguments?.getString("itemType")
                    val itemId = backStackEntry.arguments?.getString("itemId")?.toIntOrNull()

                    itemId?.let { id ->
                        DetailScreen(
                            id = id,
                            itemType = itemType ?: "product",
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TopBar(
    title: String,
    showBackButton: Boolean = false,
    onBackPressed: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        if (showBackButton) {
            IconButton(
                onClick = { onBackPressed() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    painter = painterResource(R.drawable.back),
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            image = R.drawable.home,
            screen = Routes.HOME
        ),
        NavigationItem(
            title = "Games",
            image = R.drawable.game,
            screen = Routes.GAMES
        ),
        NavigationItem(
            title = "About",
            image = R.drawable.about,
            screen = Routes.ABOUT
        )
    )

    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .height(65.dp),
        containerColor = Color.Transparent,
        tonalElevation = 4.dp
    ) {
        navigationItems.forEach { item ->
            val isSelected = currentRoute == item.screen

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navController.navigate(item.screen) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.image),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp),
                        tint = if (isSelected) Color(0xFF2196F3) else Color.White
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) Color(0xFF2196F3) else Color.Gray
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LuxoraAppPreview() {
    LuxoraTheme {
        LuxoraApp()
    }
}