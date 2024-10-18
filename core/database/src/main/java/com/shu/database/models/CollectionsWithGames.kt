package com.shu.database.models

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation


//связываем таблицы коллекции и игры.
data class CollectionsWithGames(
    @Embedded
    val collection: CollectionsDbo,
    @Relation(
        parentColumn = "collection_id",
        entityColumn = "id",
        associateBy = Junction(
            CollectionGames::class,
            parentColumn = "collection_id",
            entityColumn = "game_id"
        )
    )
    val listGame: List<GameDbo>

)
