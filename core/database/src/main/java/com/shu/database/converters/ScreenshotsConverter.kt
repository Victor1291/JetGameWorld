package com.shu.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shu.models.ShortScreenshotsDbo

class ScreenshotsConverter {
    @TypeConverter
    fun mapListToString(value: List<com.shu.models.ShortScreenshotsDbo>): String {
        val gson = Gson()
        val type = object : TypeToken<List<com.shu.models.ShortScreenshotsDbo>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun mapStringToList(value: String): List<com.shu.models.ShortScreenshotsDbo> {
        val gson = Gson()
        val type = object : TypeToken<List<com.shu.models.ShortScreenshotsDbo>>() {}.type
        return gson.fromJson(value, type)
    }
}