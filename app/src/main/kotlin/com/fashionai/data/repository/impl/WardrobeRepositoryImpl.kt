package com.fashionai.data.repository.impl

import com.fashionai.data.local.dao.WardrobeItemDao
import com.fashionai.data.local.entity.ClothingType
import com.fashionai.data.local.entity.WardrobeItemEntity
import com.fashionai.data.repository.WardrobeRepository
import com.fashionai.domain.model.WardrobeItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WardrobeRepositoryImpl @Inject constructor(
    private val wardrobeItemDao: WardrobeItemDao
) : WardrobeRepository {

    override suspend fun addItem(item: WardrobeItem): Long {
        return wardrobeItemDao.insert(item.toEntity())
    }

    override suspend fun updateItem(item: WardrobeItem) {
        wardrobeItemDao.update(item.toEntity())
    }

    override suspend fun deleteItem(item: WardrobeItem) {
        wardrobeItemDao.delete(item.toEntity())
    }

    override suspend fun getItemById(id: Long): WardrobeItem? {
        return wardrobeItemDao.getItemById(id)?.toDomain()
    }

    override fun getAllItems(): Flow<List<WardrobeItem>> {
        return wardrobeItemDao.getAllItems().map { items ->
            items.map { it.toDomain() }
        }
    }

    override fun getItemsByType(type: String): Flow<List<WardrobeItem>> {
        return wardrobeItemDao.getItemsByType(type).map { items ->
            items.map { it.toDomain() }
        }
    }

    override fun getItemsByColor(color: String): Flow<List<WardrobeItem>> {
        return wardrobeItemDao.getItemsByColor(color).map { items ->
            items.map { it.toDomain() }
        }
    }

    override suspend fun deleteAll() {
        wardrobeItemDao.deleteAll()
    }

    private fun WardrobeItem.toEntity() = WardrobeItemEntity(
        id = id,
        name = name,
        type = type,
        color = color,
        imageUri = imageUri,
        brand = brand,
        size = size,
        createdAt = createdAt,
        tags = tags.joinToString(",")
    )

    private fun WardrobeItemEntity.toDomain() = WardrobeItem(
        id = id,
        name = name,
        type = type,
        color = color,
        imageUri = imageUri,
        brand = brand,
        size = size,
        createdAt = createdAt,
        tags = tags.split(",").filter { it.isNotEmpty() }
    )
}
