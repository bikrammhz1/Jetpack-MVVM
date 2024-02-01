package com.rbmhz.jetpackmvvm.feature.auth.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rbmhz.jetpackmvvm.common.ui.ComposeNavigator
import com.rbmhz.jetpackmvvm.navigation.Navigator
import com.rbmhz.jetpackmvvm.navigation.Routes

@Composable
fun Login(
    navigator: Navigator = ComposeNavigator()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome to Login Screen!")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navigator.popUpTo(route = Routes.DASHBOARD.route, popUpToRoute = Routes.AUTH.route)
        }) {
            Text(text = "Go to Dashboard Screen")
        }
        Button(onClick = {
            navigator.navigate(route = Routes.AUTH.REGISTER.route)
        }) {
            Text(text = "Go to Register Screen")
        }
        Button(onClick = {
            navigator.navigate(route = Routes.AUTH.FORGET.route)
        }) {
            Text(text = "Go to Forget Screen")
        }
    }
}
