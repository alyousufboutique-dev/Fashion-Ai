package com.fashionai.data.repository

import com.fashionai.domain.model.Outfit
import kotlinx.coroutines.flow.Flow

interface OutfitRepository {
    suspend fun createOutfit(outfit: Outfit): Long
    suspend fun updateOutfit(outfit: Outfit)
    suspend fun deleteOutfit(outfit: Outfit)
    suspend fun getOutfitById(id: Long): Outfit?
    fun getAllOutfits(): Flow<List<Outfit>>
    fun getSavedOutfits(): Flow<List<Outfit>>
    fun getOutfitsBySeason(season: String): Flow<List<Outfit>>
    suspend fun updateSaved(id: Long, saved: Boolean)
    suspend fun deleteAll()
}
