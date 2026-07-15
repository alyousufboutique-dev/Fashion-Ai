package com.fashionai.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fashionai.data.local.dao.WardrobeItemDao
import com.fashionai.data.local.dao.OutfitDao
import com.fashionai.data.local.dao.ScanHistoryDao
import com.fashionai.data.local.entity.WardrobeItemEntity
import com.fashionai.data.local.entity.OutfitEntity
import com.fashionai.data.local.entity.ScanHistoryEntity

@Database(
    entities = [
        WardrobeItemEntity::class,
        OutfitEntity::class,
        ScanHistoryEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class FashionAIDatabase : RoomDatabase() {
    abstract fun wardrobeItemDao(): WardrobeItemDao
    abstract fun outfitDao(): OutfitDao
    abstract fun scanHistoryDao(): ScanHistoryDao
}
