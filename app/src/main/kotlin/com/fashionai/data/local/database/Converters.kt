package com.fashionai.data.local.database

import androidx.room.TypeConverter
import com.fashionai.data.local.entity.ClothingType
import java.time.Instant

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Instant? = value?.let { Instant.ofEpochMilli(it) }

    @TypeConverter
    fun toTimestamp(instant: Instant?): Long? = instant?.toEpochMilli()

    @TypeConverter
    fun fromClothingType(value: ClothingType): String = value.name

    @TypeConverter
    fun toClothingType(value: String): ClothingType = ClothingType.valueOf(value)
}
