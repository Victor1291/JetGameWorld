package com.shu.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shu.database.models.GameDbo

class GamesConverter {
    @TypeConverter
    fun mapListToString(value: List<GameDbo>): String {
        val gson = Gson()
        val type = object : TypeToken<List<GameDbo>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun mapStringToList(value: String): List<GameDbo> {
        val gson = Gson()
        val type = object : TypeToken<List<GameDbo>>() {}.type
        return gson.fromJson(value, type)
    }
}