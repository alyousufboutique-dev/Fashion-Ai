package com.fashionai.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

enum class ClothingType {
    SHIRT, PANTS, DRESS, JACKET, SHOES, ACCESSORY, OTHER
}

@Entity(tableName = "wardrobe_items")
data class WardrobeItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val type: ClothingType,
    val color: String,
    val imageUri: String,
    val brand: String = "",
    val size: String = "",
    val createdAt: Instant = Instant.now(),
    val tags: String = "" // JSON serialized list
)
