package com.rbmhz.jetpackmvvm.feature.dashboard.domain.usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rbmhz.jetpackmvvm.core.database.Database
import com.rbmhz.jetpackmvvm.feature.dashboard.data.repo.DashboardRepoImpl
import com.rbmhz.jetpackmvvm.feature.dashboard.data.source.local.BeerEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DashboardUseCase @Inject constructor(
    private val db: Database,
    private val dashboardRepo: DashboardRepoImpl
) {
    @OptIn(ExperimentalPagingApi::class)
    operator fun invoke(): Flow<PagingData<BeerEntity>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = dashboardRepo,
            pagingSourceFactory = {
                db.beerDao.getBeer()
            }
        ).flow
    }
}

class GetFakeDataUseCase @Inject constructor(
    private val dashboardRepo: DashboardRepoImpl
) {
    operator fun invoke(): Flow<List<String>> {
        return flow {
            emit(dashboardRepo.getFakeData())
        }
    }
}

