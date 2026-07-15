package com.fashionai.data.repository.impl

import com.fashionai.data.local.dao.OutfitDao
import com.fashionai.data.local.entity.OutfitEntity
import com.fashionai.data.repository.OutfitRepository
import com.fashionai.domain.model.Outfit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OutfitRepositoryImpl @Inject constructor(
    private val outfitDao: OutfitDao
) : OutfitRepository {

    override suspend fun createOutfit(outfit: Outfit): Long {
        return outfitDao.insert(outfit.toEntity())
    }

    override suspend fun updateOutfit(outfit: Outfit) {
        outfitDao.update(outfit.toEntity())
    }

    override suspend fun deleteOutfit(outfit: Outfit) {
        outfitDao.delete(outfit.toEntity())
    }

    override suspend fun getOutfitById(id: Long): Outfit? {
        return outfitDao.getOutfitById(id)?.toDomain()
    }

    override fun getAllOutfits(): Flow<List<Outfit>> {
        return outfitDao.getAllOutfits().map { outfits ->
            outfits.map { it.toDomain() }
        }
    }

    override fun getSavedOutfits(): Flow<List<Outfit>> {
        return outfitDao.getSavedOutfits().map { outfits ->
            outfits.map { it.toDomain() }
        }
    }

    override fun getOutfitsBySeason(season: String): Flow<List<Outfit>> {
        return outfitDao.getOutfitsBySeason(season).map { outfits ->
            outfits.map { it.toDomain() }
        }
    }

    override suspend fun updateSaved(id: Long, saved: Boolean) {
        outfitDao.updateSaved(id, saved)
    }

    override suspend fun deleteAll() {
        outfitDao.deleteAll()
    }

    private fun Outfit.toEntity() = OutfitEntity(
        id = id,
        name = name,
        description = description,
        itemIds = itemIds.joinToString(","),
        imageUri = imageUri,
        occasions = occasions.joinToString(","),
        season = season,
        rating = rating,
        saved = saved,
        createdAt = createdAt,
        updatedAt = updatedAt
    )

    private fun OutfitEntity.toDomain() = Outfit(
        id = id,
        name = name,
        description = description,
        itemIds = itemIds.split(",").mapNotNull { it.toLongOrNull() },
        imageUri = imageUri,
        occasions = occasions.split(",").filter { it.isNotEmpty() },
        season = season,
        rating = rating,
        saved = saved,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
