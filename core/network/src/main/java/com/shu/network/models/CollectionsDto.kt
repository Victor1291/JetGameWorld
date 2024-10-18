package com.shu.network.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collections")
data class CollectionsDto(
    @PrimaryKey(autoGenerate = false)
    val collectionsId: String,
)
