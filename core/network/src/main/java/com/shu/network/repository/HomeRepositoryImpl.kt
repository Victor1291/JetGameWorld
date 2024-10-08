package com.shu.network.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.shu.database.GameDatabase
import com.shu.models.GameDbo
import com.shu.home.domain.HomeRepository
import com.shu.models.ETitle
import com.shu.models.Game
import com.shu.models.QueryParameters
import com.shu.network.ServiceGameApi
import com.shu.network.paging.GamesRemoteMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: ServiceGameApi,
    private val gameDatabase: GameDatabase,
) : HomeRepository {

    override fun getOrdering(params: QueryParameters, title: ETitle): Flow<PagingData<Game>> {
        return  Pager(
            config = PagingConfig(pageSize = 10, initialLoadSize = 15, prefetchDistance = 4),
            pagingSourceFactory = { GamePagingSource(api,title,params) },
        ).flow
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun getOrderingCash(params: QueryParameters, title: ETitle): Flow<PagingData<GameDbo>> {
        return  Pager(
            config = PagingConfig(pageSize = 10, initialLoadSize = 15, prefetchDistance = 4),
            pagingSourceFactory = { gameDatabase.getGameDao().getGames() },
            remoteMediator = GamesRemoteMediator(api,gameDatabase)
        ).flow
    }
}

/*


Сделать для нескольких списков.

 */
