package com.fashionai.domain.model

import java.time.Instant

data class Outfit(
    val id: Long = 0,
    val name: String,
    val description: String = "",
    val itemIds: List<Long> = emptyList(),
    val imageUri: String = "",
    val occasions: List<String> = emptyList(),
    val season: String = "",
    val rating: Float = 0f,
    val saved: Boolean = false,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now()
)
