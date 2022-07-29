package com.example.composestarter

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavBarItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)

fun getBottomBarItems() = listOf(
    BottomNavBarItem(
        name = "Home",
        route = "home",
        icon = Icons.Default.Home
    ),
    BottomNavBarItem(
        name = "Profile",
        route = "home",
        icon = Icons.Default.Person
    ),
    BottomNavBarItem(
        name = "Cart",
        route = "cart",
        icon = Icons.Default.ShoppingCart
    ),
    BottomNavBarItem(
        name = "Account",
        route = "account",
        icon = Icons.Default.AccountBox
    ),
)
