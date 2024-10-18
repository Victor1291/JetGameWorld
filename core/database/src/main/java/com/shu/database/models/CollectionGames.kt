package com.shu.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "collection_games",
    primaryKeys = ["collection_id","game_id"] // два основных ключа,
)
data class CollectionGames(
    @ColumnInfo(name = "collection_id")
    val collectionId: Int,
    @ColumnInfo(name = "game_id")
    val gameId: Int
)