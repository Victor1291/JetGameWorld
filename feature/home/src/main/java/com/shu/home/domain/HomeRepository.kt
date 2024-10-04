package com.shu.home.domain


import androidx.paging.Pager
import com.shu.models.ETitle
import com.shu.models.Game
import com.shu.models.QueryParameters

interface HomeRepository {
    fun getOrdering(params: QueryParameters, title: ETitle): Pager<Int, Game>

}