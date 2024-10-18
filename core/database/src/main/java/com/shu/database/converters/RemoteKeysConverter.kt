package com.shu.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shu.database.models.RemoteKeys

class RemoteKeysConverter {
    @TypeConverter
    fun mapListToString(value: List<RemoteKeys>): String {
        val gson = Gson()
        val type = object : TypeToken<List<RemoteKeys>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun mapStringToList(value: String): List<RemoteKeys> {
        val gson = Gson()
        val type = object : TypeToken<List<RemoteKeys>>() {}.type
        return gson.fromJson(value, type)
    }
}