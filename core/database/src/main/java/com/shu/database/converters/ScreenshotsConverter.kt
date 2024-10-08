package com.shu.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shu.database.models.ShortScreenshotsDbo

class ScreenshotsConverter {
    @TypeConverter
    fun mapListToString(value: List<ShortScreenshotsDbo>): String {
        val gson = Gson()
        val type = object : TypeToken<List<ShortScreenshotsDbo>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun mapStringToList(value: String): List<ShortScreenshotsDbo> {
        val gson = Gson()
        val type = object : TypeToken<List<ShortScreenshotsDbo>>() {}.type
        return gson.fromJson(value, type)
    }
}