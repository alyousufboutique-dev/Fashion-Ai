package com.fashionai.data.repository

import com.fashionai.domain.model.ScanResult
import kotlinx.coroutines.flow.Flow

interface ScanRepository {
    suspend fun saveScan(scan: ScanResult): Long
    suspend fun deleteScan(scan: ScanResult)
    fun getAllScans(): Flow<List<ScanResult>>
    fun getRecentScans(limit: Int = 10): Flow<List<ScanResult>>
    suspend fun deleteOldScans()
    suspend fun deleteAll()
}
