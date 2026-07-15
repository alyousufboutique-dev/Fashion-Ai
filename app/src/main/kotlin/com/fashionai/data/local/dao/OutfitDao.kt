package com.fashionai.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.fashionai.data.local.entity.OutfitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OutfitDao {
    @Insert
    suspend fun insert(outfit: OutfitEntity): Long

    @Update
    suspend fun update(outfit: OutfitEntity)

    @Delete
    suspend fun delete(outfit: OutfitEntity)

    @Query("SELECT * FROM outfits WHERE id = :id")
    suspend fun getOutfitById(id: Long): OutfitEntity?

    @Query("SELECT * FROM outfits ORDER BY updatedAt DESC")
    fun getAllOutfits(): Flow<List<OutfitEntity>>

    @Query("SELECT * FROM outfits WHERE saved = 1 ORDER BY updatedAt DESC")
    fun getSavedOutfits(): Flow<List<OutfitEntity>>

    @Query("SELECT * FROM outfits WHERE season = :season")
    fun getOutfitsBySeason(season: String): Flow<List<OutfitEntity>>

    @Query("UPDATE outfits SET saved = :saved WHERE id = :id")
    suspend fun updateSaved(id: Long, saved: Boolean)

    @Query("DELETE FROM outfits")
    suspend fun deleteAll()
}
