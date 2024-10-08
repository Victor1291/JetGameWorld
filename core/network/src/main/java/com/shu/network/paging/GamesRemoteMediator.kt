package com.shu.network.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.shu.database.GameDatabase
import com.shu.database.models.RemoteKeys
import com.shu.models.Game
import com.shu.network.ServiceGameApi
import com.shu.network.models2.mapFromApiToBd
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class GamesRemoteMediator @Inject constructor(
    private val serviceGameApi: ServiceGameApi,
    private val gameDatabase: GameDatabase
) : RemoteMediator<Int, Game>() {

    override suspend fun initialize(): InitializeAction {
        val cacheTimeout = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)

        return if (System.currentTimeMillis() - (gameDatabase.getRemoteKeysDao().getCreationTime() ?: 0) < cacheTimeout) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Game>
    ): MediatorResult {
        val page: Int = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: 1
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey
                prevKey ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                nextKey ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }
        }

        try {
            val apiResponse = serviceGameApi.games(page = page)

            val games = apiResponse.results
            val endOfPaginationReached = games.isEmpty()

            gameDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    gameDatabase.getRemoteKeysDao().clearRemoteKeys()
                    gameDatabase.getGameDao().clearAllGames()
                }
                val prevKey = if (page > 1) page - 1 else null
                val nextKey = if (endOfPaginationReached) null else page + 1
                val remoteKeys = games.map {
                    RemoteKeys(
                        gameID = it.id ?: 0,
                        prevKey = prevKey,
                        currentPage = page,
                        nextKey = nextKey
                    )
                }

                gameDatabase.getRemoteKeysDao().insertAll(remoteKeys)
                gameDatabase.getGameDao().insertAll(games.map { it.mapFromApiToBd(page) })
            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (error: IOException) {
            return MediatorResult.Error(error)
        } catch (error: HttpException) {
            return MediatorResult.Error(error)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, Game>): RemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                gameDatabase.getRemoteKeysDao().getRemoteKeyByGameID(id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, Game>): RemoteKeys? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()?.let { game ->
            gameDatabase.getRemoteKeysDao().getRemoteKeyByGameID(game.id ?: 0)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, Game>): RemoteKeys? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let { game ->
            gameDatabase.getRemoteKeysDao().getRemoteKeyByGameID(game.id ?: 0)
        }
    }

}