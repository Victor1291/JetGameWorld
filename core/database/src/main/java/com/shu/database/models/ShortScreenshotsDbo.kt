package com.shu.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shu.models.ShortScreenshots

@Entity(tableName = "screens")
data class ShortScreenshotsDbo(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = null,
    @ColumnInfo(name = "image")
    var image: String? = null
)


fun ShortScreenshotsDbo.mapFromBd(): ShortScreenshots {
    return with(this) {
        ShortScreenshots(
            id = id,
            image = image,
        )
    }
}