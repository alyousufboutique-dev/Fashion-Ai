package com.fashionai.domain.model

import java.time.Instant

data class ScanResult(
    val id: Long = 0,
    val imageUri: String,
    val detectedItems: List<WardrobeItem> = emptyList(),
    val suggestedOutfits: List<Outfit> = emptyList(),
    val confidence: Float = 0f,
    val timestamp: Instant = Instant.now()
)
