package com.shu.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameDbo(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "released")
    val released: String,
    @ColumnInfo(name = "backgroundImage")
    val backgroundImage: String?,
    @ColumnInfo(name = "added")
    val added: Int?,
    @ColumnInfo(name = "rating")
    val rating: Double?,
    @ColumnInfo(name = "platforms")
    var platforms        : String?                     = null,
    @ColumnInfo(name = "clip")
    var clip             : String?                     = null,
    @ColumnInfo(name = "userGame")
    var userGame         : String?                     = null,
    @ColumnInfo(name = "shortScreenshots")
    var shortScreenshots : List<ShortScreenshotsDbo> = listOf(),
    @ColumnInfo(name = "genres")
    var genres           : String?                     = null,
    @ColumnInfo(name = "page")
    var page: Int,
)


