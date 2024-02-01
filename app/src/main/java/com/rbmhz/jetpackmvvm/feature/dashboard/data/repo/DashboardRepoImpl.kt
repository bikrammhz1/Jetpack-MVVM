package com.rbmhz.jetpackmvvm.feature.dashboard.data.repo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.rbmhz.jetpackmvvm.core.database.Database
import com.rbmhz.jetpackmvvm.feature.dashboard.data.source.local.BeerDao
import com.rbmhz.jetpackmvvm.feature.dashboard.data.source.local.BeerEntity
import com.rbmhz.jetpackmvvm.feature.dashboard.data.source.remote.BeerRemoteImpl
import com.rbmhz.jetpackmvvm.feature.dashboard.domain.repo.DashboardRepo
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class DashboardRepoImpl @Inject
constructor(
    private val db: Database,
    private val dao: BeerDao,
    private val beerRemoteApi: BeerRemoteImpl,
) : DashboardRepo, RemoteMediator<Int, BeerEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BeerEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }

            val beers = beerRemoteApi.getBeer(
                page = loadKey,
                pageCount = state.config.pageSize
            )

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    dao.clearAll()
                }
                val beerEntities = beers.map { it.toBeerEntity() }
                dao.upsertAll(beerEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = beers.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    override suspend fun getFakeData(): List<String> {
        return listOf("'1', '2', '3', '4', '5', '6'")
    }

}
