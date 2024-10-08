package com.shu.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shu.database.converters.ScreenshotsConverter
import com.shu.database.models.GameDbo
import com.shu.database.models.RemoteKeys
import com.shu.database.models.ShortScreenshotsDbo

@Database(
    entities = [
        GameDbo::class,
        ShortScreenshotsDbo::class,
        RemoteKeys::class,
    ], version = 1, exportSchema = false
)
@TypeConverters(ScreenshotsConverter::class)
abstract class GameDatabase : RoomDatabase() {
    abstract fun getGameDao(): GameDao
    abstract fun getRemoteKeysDao(): RemoteKeysDao


}
