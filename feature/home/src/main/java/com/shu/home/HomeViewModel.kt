package com.shu.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.shu.home.domain.HomeRepository
import com.shu.models.ETitle
import com.shu.models.Game
import com.shu.models.QueryParameters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    val listGamePlatforms: Flow<PagingData<Game>>
    val listDevelopers: Flow<PagingData<Game>>
    val listPlaystation: Flow<PagingData<Game>>
    val listPopular: Flow<PagingData<Game>>
    val listReleased: Flow<PagingData<Game>>
    val listWaiting: Flow<PagingData<Game>>
    val listLastYear: Flow<PagingData<Game>>

    init {

        listGamePlatforms = repository.getOrdering(
            params = QueryParameters(
                ordering = "added"
            ), title = ETitle.Platforms
        ).flow.cachedIn(viewModelScope)

        listDevelopers = repository.getOrdering(
            params = QueryParameters(
                ordering = "added"
            ), title = ETitle.Developers
        ).flow.cachedIn(viewModelScope)

        listPlaystation = repository.getOrdering(
            params = QueryParameters(
                platforms = "18"
            ), title = ETitle.Developers
        ).flow.cachedIn(viewModelScope)

        listPopular = repository.getOrdering(
            params = QueryParameters(
                ordering = "added"
            ), title = ETitle.Popular
        ).flow.cachedIn(viewModelScope)

        listReleased = repository.getOrdering(
            params = QueryParameters(
                ordering = "released"
            ), title = ETitle.Released
        ).flow.cachedIn(viewModelScope)

        listWaiting = repository.getOrdering(
            params = QueryParameters(
                ordering = "added",
                dates = "2024-10-01,2025-10-01"
            ), title = ETitle.Awaiting
        ).flow.cachedIn(viewModelScope)

        listLastYear = repository.getOrdering(
            params = QueryParameters(
                ordering = "added",
                dates = "2023-10-01,2024-10-01"
            ), title = ETitle.LastYear
        ).flow.cachedIn(viewModelScope)
    }

    private fun getTime(): String {
        val date = Date()
        val calendar: Calendar = GregorianCalendar()
        calendar.time = date
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH] + 1
        val day = calendar[Calendar.DAY_OF_MONTH]
        return if (month < 10) "$year-0$month-$day" else "$year-$month-$day"
    }

}
