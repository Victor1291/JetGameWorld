package com.shu.network.repository

import com.shu.home.domain.HomeRepository
import com.shu.models.ManyScreens
import com.shu.models.QueryParameters
import com.shu.network.ServiceGameApi
import com.shu.network.mPlatforms.ResponsePlatforms
import com.shu.network.mPlatforms.mapFromApi
import com.shu.network.models2.PagedResponseDto
import com.shu.network.models2.mapFromApi
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: ServiceGameApi,
    //private val movieDao: MovieDao,
) : HomeRepository {

    override suspend fun getAllNewScreen(): ManyScreens {

        return coroutineScope {

            val listTitle =
                mutableListOf(
                    "Platforms",
                    "Developers",
                    "Playstation 4",
                    "Popular",
                    "Released",
                    "Awaiting",
                    "Last Year",
                )


            val listGamePlatforms =
                async {
                    getPlatform(
                        params = QueryParameters(
                            ordering = "added"
                        )
                    ).results.map { it.mapFromApi() }
                }

            val listDevelopers =
                async {
                    getDevelopers(
                        params = QueryParameters()
                    ).results.map { it.mapFromApi() }
                }

            val listPlatforms =
                async {
                    getGamePlatforms(
                        params = QueryParameters(
                            platforms = "18" //Playstation 4
                        )
                    ).results.map { it.mapFromApi() }
                }

            val listPopular =
                async { getOrdering(params = QueryParameters(ordering = "added")).results.map { it.mapFromApi() } }

            val listRating =
                async { getOrdering(params = QueryParameters(ordering = "released")).results.map { it.mapFromApi() } }

            val listWaiting =
                async {
                    getDate(
                        params = QueryParameters(
                            ordering = "added",
                            dates = "2024-10-01,2025-10-01"
                        )
                    ).results.map { it.mapFromApi() }
                }
            val listLastYear =
                async {
                    getDate(
                        params = QueryParameters(
                            ordering = "added",
                            dates = "2023-10-01,2024-10-01"
                        )
                    ).results.map { it.mapFromApi() }
                }

            return@coroutineScope ManyScreens(
                homeListScreen = listOf(
                    listGamePlatforms.await(),
                    listDevelopers.await(),
                    listPlatforms.await(),
                    listPopular.await(),
                    listRating.await(),
                    listWaiting.await(),
                    listLastYear.await(),
                ),
                listTitle = listTitle.toList(),
            )
        }
    }

    private suspend fun getGamePlatforms(params: QueryParameters): PagedResponseDto {
        return api.gamesPlatforms(
            page = params.page,
            pageSize = params.pageSize,
            platforms = params.platforms
        )
    }

    private suspend fun getOrdering(params: QueryParameters): PagedResponseDto {
        return api.gamesPopular(
            page = params.page,
            pageSize = params.pageSize,
            ordering = params.ordering
        )
    }

    private suspend fun getDate(params: QueryParameters): PagedResponseDto {
        return api.gamesDate(
            page = params.page,
            pageSize = params.pageSize,
            ordering = params.ordering,
            dates = params.dates
        )
    }

    private suspend fun getPlatform(params: QueryParameters): ResponsePlatforms {
        return api.platforms(
            page = params.page,
            pageSize = params.pageSize,
            ordering = params.ordering,
        )
    }

    private suspend fun getDevelopers(params: QueryParameters): ResponsePlatforms {
        return api.platforms(
            page = params.page,
            pageSize = params.pageSize,
        )
    }
}
