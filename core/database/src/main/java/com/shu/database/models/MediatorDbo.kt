package com.shu.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mediators")
data class MediatorDbo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "collection_id")
    val collectionId: Int,
    @ColumnInfo(name = "list_game")
    val listGame: List<GameDbo>,
    @ColumnInfo(name = "list_keys")
    val listKeys: List<RemoteKeys>,
)

