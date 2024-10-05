package com.shu.network.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.shu.home.domain.HomeRepository
import com.shu.models.ETitle
import com.shu.models.Game
import com.shu.models.QueryParameters
import com.shu.network.ServiceGameApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: ServiceGameApi,
    //private val movieDao: MovieDao,
) : HomeRepository {

    override fun getOrdering(params: QueryParameters, title: ETitle): Flow<PagingData<Game>> {
        return  Pager(
            config = PagingConfig(pageSize = 10, initialLoadSize = 15, prefetchDistance = 4),
            pagingSourceFactory = { GamePagingSource(api,title,params) }
        ).flow
    }
}
