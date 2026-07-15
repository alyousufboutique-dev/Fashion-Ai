package com.fashionai.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fashionai.data.local.entity.ScanHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ScanHistoryDao {
    @Insert
    suspend fun insert(scan: ScanHistoryEntity): Long

    @Delete
    suspend fun delete(scan: ScanHistoryEntity)

    @Query("SELECT * FROM scan_history ORDER BY timestamp DESC")
    fun getAllScans(): Flow<List<ScanHistoryEntity>>

    @Query("SELECT * FROM scan_history ORDER BY timestamp DESC LIMIT :limit")
    fun getRecentScans(limit: Int = 10): Flow<List<ScanHistoryEntity>>

    @Query("DELETE FROM scan_history WHERE timestamp < datetime('now', '-30 days')")
    suspend fun deleteOldScans()

    @Query("DELETE FROM scan_history")
    suspend fun deleteAll()
}
