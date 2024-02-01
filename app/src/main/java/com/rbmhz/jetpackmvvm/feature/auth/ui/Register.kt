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
import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import com.rbmhz.jetpackmvvm.common.ui.TopBar
import com.rbmhz.jetpackmvvm.common.ui.ComposeNavigator
import com.rbmhz.jetpackmvvm.navigation.Navigator
import com.rbmhz.jetpackmvvm.navigation.Routes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(
    navigator: Navigator = ComposeNavigator()
) {
    Scaffold(
        topBar = { TopBar(title = "Register", onMenuClicked = {navigator.pop()}) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Welcome to Register Screen!")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    navigator.popNavigate(route = Routes.AUTH.FORGET.route)
                }) {
                    Text(text = "Go to Forget Screen")
                }
            }
        }
    )
}


