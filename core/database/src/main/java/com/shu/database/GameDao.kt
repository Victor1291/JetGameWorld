package com.shu.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shu.models.GameDbo

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(games: List<com.shu.models.GameDbo>)

    @Query("Select * From games Order By page")
    fun getGames(): PagingSource<Int, com.shu.models.GameDbo>

    @Query("Delete From games")
    suspend fun clearAllGames()


}