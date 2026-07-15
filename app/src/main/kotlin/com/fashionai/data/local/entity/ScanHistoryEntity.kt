package com.fashionai.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(tableName = "scan_history")
data class ScanHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val imageUri: String,
    val detectedItems: String = "", // JSON serialized list
    val suggestedOutfits: String = "", // JSON serialized list
    val confidence: Float = 0f,
    val timestamp: Instant = Instant.now()
)
