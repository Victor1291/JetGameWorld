package com.shu.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.shu.home.domain.HomeRepository
import com.shu.models.ETitle
import com.shu.models.Game
import com.shu.models.GameDbo
import com.shu.models.QueryParameters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

//    val choiceGenre: Flow<PagingData<Game>> = repository.getOrdering(
//        params = QueryParameters(), title = ETitle.ChoiceGenre
//    ).cachedIn(viewModelScope)
//    var listOfGenre: Flow<PagingData<Game>>
//    var listOfPlatform: Flow<PagingData<Game>>
//    val listGamePlatforms: Flow<PagingData<Game>>
//    val listPlaystation: Flow<PagingData<Game>>
//    val listPopular: Flow<PagingData<Game>>
//    val listReleased: Flow<PagingData<Game>>
//    val listWaiting: Flow<PagingData<Game>>
//    val listLastYear: Flow<PagingData<Game>>
    val listAllGame: Flow<PagingData<GameDbo>>

//    private var _genre = MutableStateFlow("1")
//    private val genre = _genre.asStateFlow()
//
//    private var _platform = MutableStateFlow("1")
//    private val platform = _platform.asStateFlow()

    private var listTitle = mutableListOf(
        "Choice Genre",
        "Genre",
        "Choice Platform",
        "Playstation 4",
        "Popular",
        "Released",
        "Nintendo Switch",
        "Last Year",
    )

    init {

        listAllGame = repository.getOrderingCash(
            params = QueryParameters(
                ordering = "added"
            ), title = ETitle.Platforms
        ).cachedIn(viewModelScope)

//        listGamePlatforms = repository.getOrdering(
//            params = QueryParameters(
//                ordering = "added"
//            ), title = ETitle.Platforms
//        ).cachedIn(viewModelScope)
//
//        listPlaystation = repository.getOrdering(
//            params = QueryParameters(
//                platforms = "18"
//            ), title = ETitle.Playstation
//        ).cachedIn(viewModelScope)
//
//        listPopular = repository.getOrdering(
//            params = QueryParameters(
//                ordering = "added"
//            ), title = ETitle.Popular
//        ).cachedIn(viewModelScope)
//
//        listReleased = repository.getOrdering(
//            params = QueryParameters(
//                ordering = "released"
//            ), title = ETitle.Released
//        ).cachedIn(viewModelScope)
//
//        listWaiting = repository.getOrdering(
//            params = QueryParameters(
//                platforms = "7"
//            ), title = ETitle.Playstation
//        ).cachedIn(viewModelScope)
//
//        listLastYear = repository.getOrdering(
//            params = QueryParameters(
//                ordering = "added",
//                dates = "2023-10-01,2024-10-01"
//            ), title = ETitle.LastYear
//        ).cachedIn(viewModelScope)
//
//        listOfGenre = getGenres(genre.value)
//        listOfPlatform = getPlatform(platform.value)

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

//    fun setGenre(genreNew: Int) {
//        _genre.value = genreNew.toString()
//        listOfGenre = getGenres(genreNew.toString())
//    }

    private fun getGenres(gen: String) = repository.getOrdering(
        params = QueryParameters(
            genres = gen
        ), title = ETitle.Genres
    ).cachedIn(viewModelScope)

    private fun getPlatform(pl: String) = repository.getOrdering(
        params = QueryParameters(
            platforms = pl
        ), title = ETitle.Playstation
    ).cachedIn(viewModelScope)

//    fun setPlatform(id: Int) {
//        _platform.value = id.toString()
//        listOfPlatform = getPlatform(id.toString())
//    }

}
