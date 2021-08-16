package com.arvind.jetcomposeloginui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arvind.jetcomposeloginui.view.Dashboard
import com.arvind.jetcomposeloginui.view.HomeScreen
import com.arvind.jetcomposeloginui.view.LoginScreen
import com.arvind.jetcomposeloginui.view.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(Screen.HomeScreen.route) {
            Dashboard()
        }

    }
}