package com.rbmhz.jetpackmvvm.navigation

import androidx.navigation.NavController
import javax.inject.Inject

class Navigator @Inject constructor() {
    private lateinit var navController: NavController

    fun setNavController(controller: NavController) {
        if (!::navController.isInitialized) {
            navController = controller
        }
    }

    fun navigate(): NavController {
        return navController
    }

    fun navigate(route: String) {
        if (::navController.isInitialized) {
            navController.navigate(route = route)
        }
    }
    fun popNavigate(route: String) {
        if (::navController.isInitialized) {
            navController.popBackStack()
            navController.navigate(route = route)
        }
    }

    fun pop() {
        if (::navController.isInitialized) {
            navController.popBackStack()
        }
    }

    fun popUpTo(route: String, popUpToRoute: String) {
        if (::navController.isInitialized) {
            navController.navigate(route) {
                popUpTo(popUpToRoute) {
                    inclusive = true
                }
            }
        }
    }
}