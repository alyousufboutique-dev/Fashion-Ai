package com.fashionai.domain.model

import java.time.Instant

enum class ClothingType {
    SHIRT, PANTS, DRESS, JACKET, SHOES, ACCESSORY, OTHER
}

data class WardrobeItem(
    val id: Long = 0,
    val name: String,
    val type: ClothingType,
    val color: String,
    val imageUri: String,
    val brand: String = "",
    val size: String = "",
    val createdAt: Instant = Instant.now(),
    val tags: List<String> = emptyList()
)
