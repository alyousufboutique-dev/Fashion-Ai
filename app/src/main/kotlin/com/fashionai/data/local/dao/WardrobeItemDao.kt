package com.fashionai.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.fashionai.data.local.entity.WardrobeItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WardrobeItemDao {
    @Insert
    suspend fun insert(item: WardrobeItemEntity): Long

    @Update
    suspend fun update(item: WardrobeItemEntity)

    @Delete
    suspend fun delete(item: WardrobeItemEntity)

    @Query("SELECT * FROM wardrobe_items WHERE id = :id")
    suspend fun getItemById(id: Long): WardrobeItemEntity?

    @Query("SELECT * FROM wardrobe_items ORDER BY createdAt DESC")
    fun getAllItems(): Flow<List<WardrobeItemEntity>>

    @Query("SELECT * FROM wardrobe_items WHERE type = :type")
    fun getItemsByType(type: String): Flow<List<WardrobeItemEntity>>

    @Query("SELECT * FROM wardrobe_items WHERE color = :color")
    fun getItemsByColor(color: String): Flow<List<WardrobeItemEntity>>

    @Query("DELETE FROM wardrobe_items")
    suspend fun deleteAll()
}
