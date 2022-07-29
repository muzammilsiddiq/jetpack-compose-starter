package com.example.composestarter

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object ProductDetail : Screen("product_detail")
    object Profile : Screen("profile")
    object Cart : Screen("cart")
    object Account : Screen("account")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}