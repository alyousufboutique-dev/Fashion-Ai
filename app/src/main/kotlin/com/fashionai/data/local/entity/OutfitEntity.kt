package com.fashionai.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(tableName = "outfits")
data class OutfitEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String = "",
    val itemIds: String = "", // JSON serialized list of WardrobeItemEntity IDs
    val imageUri: String = "",
    val occasions: String = "", // JSON serialized list
    val season: String = "",
    val rating: Float = 0f,
    val saved: Boolean = false,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now()
)
