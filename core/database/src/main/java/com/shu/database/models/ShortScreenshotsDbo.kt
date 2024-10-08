package com.shu.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "screens")
data class ShortScreenshotsDbo(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = null,
    @ColumnInfo(name = "image")
    var image: String? = null
)
