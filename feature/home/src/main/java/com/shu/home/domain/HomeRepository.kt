package com.shu.home.domain


import androidx.paging.PagingData
import com.shu.models.ETitle
import com.shu.models.Game
import com.shu.models.QueryParameters
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getOrdering(params: QueryParameters, title: ETitle): Flow<PagingData<Game>>
    fun getOrderingCash(params: QueryParameters, title: ETitle): Flow<PagingData<Game>>


}