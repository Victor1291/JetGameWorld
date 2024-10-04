package com.shu.network.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shu.models.ETitle
import com.shu.models.Game
import com.shu.models.QueryParameters
import com.shu.network.ServiceGameApi
import com.shu.network.mPlatforms.mapFromApi
import com.shu.network.models2.mapFromApi

class GamePagingSource(
    private val serviceGameApi: ServiceGameApi,
    private val title: ETitle,
    private val parameters: QueryParameters
) : PagingSource<Int, Game>() {

    override fun getRefreshKey(state: PagingState<Int, Game>): Int = FIRST_PAGE

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        val page = params.key ?: FIRST_PAGE
        return kotlin.runCatching {
            when (title) {
                ETitle.Platforms -> serviceGameApi.platforms(page = page).results.map { it.mapFromApi() }
                ETitle.Developers -> serviceGameApi.developers(page = page).results.map { it.mapFromApi() }
                ETitle.Playstation -> serviceGameApi.gamesPlatforms( page = page, platforms = parameters.platforms ).results.map { it.mapFromApi() }
                ETitle.Popular -> serviceGameApi.gamesPopular(page = page, ordering = "added").results.map { it.mapFromApi() }
                ETitle.Released -> serviceGameApi.gamesPopular(page = page, ordering = "released").results.map { it.mapFromApi() }
                else -> serviceGameApi.gamesDate(
                    page = page,
                    ordering = parameters.ordering,
                    dates = parameters.dates
                ).results.map { it.mapFromApi() }
            }
        }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it,
                    prevKey = if (page == FIRST_PAGE) null else page - 1,
                    nextKey = if (it.isEmpty()) null else page + 1
                )

            },
            onFailure = {
                LoadResult.Error(it)
            }
        )
    }

    private companion object {
        private const val FIRST_PAGE = 1
    }
}
