package com.shu.network.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.insertSeparators
import androidx.paging.map
import com.shu.database.GameDatabase
import com.shu.database.models.mapFromBd
import com.shu.home.domain.HomeRepository
import com.shu.models.ETitle
import com.shu.models.Game
import com.shu.models.QueryParameters
import com.shu.network.ServiceGameApi
import com.shu.network.paging.GamesRemoteMediator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: ServiceGameApi,
    private val gameDatabase: GameDatabase,
) : HomeRepository {

    override fun getOrdering(params: QueryParameters, title: ETitle): Flow<PagingData<Game>> {
        return Pager(
            config = PagingConfig(pageSize = 10, initialLoadSize = 15, prefetchDistance = 4),
            pagingSourceFactory = { GamePagingSource(api, title, params) },
        ).flow
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun getOrderingCash(params: QueryParameters, title: ETitle): Flow<PagingData<Game>> {
        return Pager(
            config = PagingConfig(pageSize = 10, initialLoadSize = 15, prefetchDistance = 4),
            pagingSourceFactory = { gameDatabase.getGameDao().getGames() },
            remoteMediator = GamesRemoteMediator(api, gameDatabase)
        ).flow.map { pagingData ->
            pagingData
                .map { it.mapFromBd() }
                /*.insertSeparators { before: Game?, after: Game? ->
                    if (before == null && after == null) {
                        // List is empty after fully loaded; return null to skip adding separator.
                        null
                    } else if (after == null) {
                        // Footer; return null here to skip adding a footer.
                        null
                    } else if (before == null) {
                        // Header
                        after.copy(title = after.page.toString())
                       // null
                    } else //if (!before.title.first().equals(after.title.first(), ignoreCase = true)){
                    // Between two items that start with different letters.
                        after.copy(title = after.clip ?: "")
                    // } else {
                    // Between two items that start with the same letter.
                    //    null
                }*/

        }
    }
}

/*


Сделать для нескольких списков.

 */
