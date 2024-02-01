package com.rbmhz.jetpackmvvm.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.rbmhz.jetpackmvvm.feature.auth.ui.Forget
import com.rbmhz.jetpackmvvm.feature.dashboard.presentation.ui.Dashboard
import com.rbmhz.jetpackmvvm.feature.auth.ui.Login
import com.rbmhz.jetpackmvvm.feature.auth.ui.Register
import com.rbmhz.jetpackmvvm.feature.splash.SplashScreen

@Composable
fun Navigation(
    navController: Navigator
) {
    val controller = rememberNavController()
    Log.d("Navigator", "setController:1 $controller")

    navController.setNavController(controller)

    NavHost(navController = controller, startDestination = Routes.SPLASHSCREEN.route) {
        composable(route = Routes.SPLASHSCREEN.route) {
            SplashScreen()
        }
        composable(route = Routes.DASHBOARD.route) {
            Dashboard()
        }
        navigation(
            startDestination = Routes.AUTH.LOGIN.route,
            route = Routes.AUTH.route
        ) {
            composable(Routes.AUTH.LOGIN.route) {
                Login()
            }
            composable(Routes.AUTH.REGISTER.route) {
                Register()
            }
            composable(Routes.AUTH.FORGET.route) {
                Forget()
            }
        }
    }
}

sealed class Routes(val route: String) {
    object SPLASHSCREEN : Routes("splashScreen")
    object DASHBOARD : Routes("dashboardScreen")
    object AUTH : Routes("auth") {
        object LOGIN : Routes("login")
        object REGISTER : Routes("register")
        object FORGET : Routes("forget")
    }
}
