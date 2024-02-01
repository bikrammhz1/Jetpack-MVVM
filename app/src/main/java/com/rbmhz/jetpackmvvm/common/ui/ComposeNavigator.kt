package com.rbmhz.jetpackmvvm.common.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.rbmhz.jetpackmvvm.di.NavEntryPoint
import com.rbmhz.jetpackmvvm.navigation.Navigator
import dagger.hilt.android.EntryPointAccessors

/// use for navigation inject this to the other compose components to use navigation
@Composable
fun ComposeNavigator(): Navigator {
    val context = LocalContext.current
    val entryPoint = EntryPointAccessors.fromApplication(
        context,
        NavEntryPoint::class.java
    )
    return entryPoint.Navigator()
}


