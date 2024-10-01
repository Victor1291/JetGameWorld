package com.shu.network.repository

import android.icu.text.SimpleDateFormat
import com.shu.home.domain.HomeRepository
import com.shu.models.ManyScreens
import com.shu.models.QueryParameters
import com.shu.network.ServiceGameApi
import com.shu.network.models2.PagedResponseDto
import com.shu.network.models2.mapFromApi
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: ServiceGameApi,
    //private val movieDao: MovieDao,
) : HomeRepository {

    override suspend fun getAllNewScreen(): ManyScreens {

        return coroutineScope {

            val listTitle =
                mutableListOf("Platforms", "Popular", "Released", "Metacritic", "", "Сериалы")


            val date = Date()
            val calendar = Calendar.getInstance()
            calendar.time = date
            val year = calendar[Calendar.YEAR]
            val month = calendar.getDisplayName(
                Calendar.MONTH,
                Calendar.LONG_FORMAT, Locale("en")
            )

            val listPlatforms =
                async { getPlatforms(params = QueryParameters()).results.map { it.mapFromApi() } }
            val listPopular =
                async { getOrdering(params = QueryParameters(ordering = "added")).results.map { it.mapFromApi() } }

            val listRating =
                async { getOrdering(params = QueryParameters(ordering = "released")).results.map { it.mapFromApi() } }

            val listMetacritic =
                async { getOrdering(params = QueryParameters(ordering = "metacritic")).results.map { it.mapFromApi() } }


            return@coroutineScope ManyScreens(
                homeListScreen = listOf(
                    listPlatforms.await(),
                    listPopular.await(),
                    listRating.await(),
                    listMetacritic.await(),
                ),
                listTitle = listTitle.toList(),
            )
        }
    }

    private fun getTime(): String {
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    }

    private suspend fun getPlatforms(params: QueryParameters): PagedResponseDto {
        return api.gamesPlatforms(
            page = params.page,
            number = params.pageSize,
            platforms = params.platforms
        )
    }

    private suspend fun getOrdering(params: QueryParameters): PagedResponseDto {
        return api.gamesPopular(
            page = params.page,
            number = params.pageSize,
            ordering = params.ordering
        )
    }
}
