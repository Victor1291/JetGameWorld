package com.shu.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shu.database.models.CollectionsWithGames
import com.shu.database.models.GameDbo
import com.shu.database.models.MediatorDbo

@Dao
interface MediatorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(games: List<MediatorDbo>)

    //проблемма с реализацией дао. пейджсоурс требует номер страницы их бд тоже.
    //т.е. я нн могу получать пагинированные данные для каждого отдельного списка пагенировано

    // получать данные по номеру коллекции , это возможно . Запрос

    @Query("Select * From mediators WHERE collection_id = :collectionId ")
    fun getGames(collectionId: Int): PagingSource<Int, List<CollectionsWithGames>>

    @Query("Delete From games")
    suspend fun clearAllGames()

}