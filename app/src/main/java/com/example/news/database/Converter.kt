package com.example.news.database

import androidx.room.TypeConverter
import com.example.news.models.Source

class Converter {

    @TypeConverter
    fun FromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun ToSource(name: String): Source{
        return Source(name, name)
    }
}