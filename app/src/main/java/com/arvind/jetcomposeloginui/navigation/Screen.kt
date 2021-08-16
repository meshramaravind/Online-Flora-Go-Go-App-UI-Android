package com.arvind.jetcomposeloginui.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")

}
