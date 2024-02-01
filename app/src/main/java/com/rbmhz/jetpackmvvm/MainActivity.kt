package com.rbmhz.jetpackmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rbmhz.jetpackmvvm.common.ui.SystemStatusBar
import com.rbmhz.jetpackmvvm.navigation.Navigation
import com.rbmhz.jetpackmvvm.navigation.Navigator
import com.rbmhz.jetpackmvvm.ui.theme.JetpackMVVMTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackMVVMTheme {
                SystemStatusBar()
                Navigation(navigator)
            }
        }
    }
}
