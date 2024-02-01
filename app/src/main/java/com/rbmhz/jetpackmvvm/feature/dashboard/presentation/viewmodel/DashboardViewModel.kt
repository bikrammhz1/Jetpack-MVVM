package com.rbmhz.jetpackmvvm.feature.dashboard.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.rbmhz.jetpackmvvm.feature.dashboard.domain.usecase.DashboardUseCase
import com.rbmhz.jetpackmvvm.feature.dashboard.domain.usecase.GetFakeDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    dashboardUseCase: DashboardUseCase,
    fakeData: GetFakeDataUseCase,
) : ViewModel() {
    init {
        viewModelScope.launch {
            fakeData().collect { list ->
                Log.d("tjos==> ,",list.toString())
            }
        }
    }

    val beerPagingFlow = dashboardUseCase()
        .map { pagingData ->
            pagingData.map { it.toBeer() }
        }
        .cachedIn(viewModelScope)

}