package com.fashionai.data.repository

import com.fashionai.domain.model.WardrobeItem
import kotlinx.coroutines.flow.Flow

interface WardrobeRepository {
    suspend fun addItem(item: WardrobeItem): Long
    suspend fun updateItem(item: WardrobeItem)
    suspend fun deleteItem(item: WardrobeItem)
    suspend fun getItemById(id: Long): WardrobeItem?
    fun getAllItems(): Flow<List<WardrobeItem>>
    fun getItemsByType(type: String): Flow<List<WardrobeItem>>
    fun getItemsByColor(color: String): Flow<List<WardrobeItem>>
    suspend fun deleteAll()
}
