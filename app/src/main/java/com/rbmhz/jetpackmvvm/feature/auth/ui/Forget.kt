package com.rbmhz.jetpackmvvm.feature.auth.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rbmhz.jetpackmvvm.common.ui.TopBar
import com.rbmhz.jetpackmvvm.common.ui.ComposeNavigator
import com.rbmhz.jetpackmvvm.navigation.Navigator
import com.rbmhz.jetpackmvvm.navigation.Routes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Forget(
    navigator: Navigator = ComposeNavigator()
) {
    Scaffold(
        topBar = { TopBar(title = "Forget", onMenuClicked = {navigator.pop()}) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Forget")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    navigator.popNavigate(route = Routes.AUTH.REGISTER.route)
                }) {
                    Text(text = "Go to Register Screen")
                }
            }
        }
    )
}

