package com.shu.network.repository

import android.icu.text.SimpleDateFormat
import com.shu.home.domain.HomeRepository
import com.shu.models.ManyScreens
import com.shu.models.QueryParameters
import com.shu.network.ServiceGameApi
import com.shu.network.model.base.PagedResponse
import com.shu.network.model.mapFromApi
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

            val listTitle = mutableListOf("Platforms", "Популярное", "Топ 250", "", "", "Сериалы")


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


            return@coroutineScope ManyScreens(
                homeListScreen = listOf(
                    listPlatforms.await(),
                ),
                listTitle = listTitle.toList(),
            )
        }
    }

    private fun getTime(): String {
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    }

    private suspend fun getPlatforms(params: QueryParameters): PagedResponse {
        return api.gamesPlatforms(
            page = params.page,
            number = params.pageSize,
            platforms = params.platforms
        )
    }
}