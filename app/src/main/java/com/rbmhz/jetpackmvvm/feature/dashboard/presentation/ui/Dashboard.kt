package com.rbmhz.jetpackmvvm.feature.dashboard.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.rbmhz.jetpackmvvm.feature.dashboard.presentation.state.Beer
import com.rbmhz.jetpackmvvm.feature.dashboard.presentation.viewmodel.DashboardViewModel

@Composable
fun Dashboard(
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val beers: LazyPagingItems<Beer> = viewModel.beerPagingFlow.collectAsLazyPagingItems()
    val context = LocalContext.current
    LaunchedEffect(key1 = beers.loadState) {
        if (beers.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (beers.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (beers.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                items(count = beers.itemCount) { index ->
                    beers[index]?.let {
                        BeerItem(
                            beer = it,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                item {
                    if (beers.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}

