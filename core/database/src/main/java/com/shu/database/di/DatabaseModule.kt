package com.shu.database.di

import android.content.Context
import androidx.room.Room
import com.shu.database.GameDao
import com.shu.database.GameDatabase
import com.shu.database.RemoteKeysDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): GameDatabase =
        Room.databaseBuilder(
            checkNotNull(context.applicationContext),
            GameDatabase::class.java,
            "raw_games"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideWeatherDao(appDatabase: GameDatabase): GameDao {
        return appDatabase.getGameDao()
    }

    @Singleton
    @Provides
    fun provideRemoteKeysDao(appDatabase: GameDatabase): RemoteKeysDao =
        appDatabase.getRemoteKeysDao()

}
