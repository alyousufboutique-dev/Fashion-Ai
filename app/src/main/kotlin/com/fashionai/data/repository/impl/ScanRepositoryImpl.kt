package com.fashionai.data.repository.impl

import com.fashionai.data.local.dao.ScanHistoryDao
import com.fashionai.data.local.entity.ScanHistoryEntity
import com.fashionai.data.repository.ScanRepository
import com.fashionai.domain.model.ScanResult
import com.fashionai.domain.model.WardrobeItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ScanRepositoryImpl @Inject constructor(
    private val scanHistoryDao: ScanHistoryDao
) : ScanRepository {

    override suspend fun saveScan(scan: ScanResult): Long {
        return scanHistoryDao.insert(scan.toEntity())
    }

    override suspend fun deleteScan(scan: ScanResult) {
        scanHistoryDao.delete(scan.toEntity())
    }

    override fun getAllScans(): Flow<List<ScanResult>> {
        return scanHistoryDao.getAllScans().map { scans ->
            scans.map { it.toDomain() }
        }
    }

    override fun getRecentScans(limit: Int): Flow<List<ScanResult>> {
        return scanHistoryDao.getRecentScans(limit).map { scans ->
            scans.map { it.toDomain() }
        }
    }

    override suspend fun deleteOldScans() {
        scanHistoryDao.deleteOldScans()
    }

    override suspend fun deleteAll() {
        scanHistoryDao.deleteAll()
    }

    private fun ScanResult.toEntity() = ScanHistoryEntity(
        id = id,
        imageUri = imageUri,
        detectedItems = "", // TODO: Implement JSON serialization
        suggestedOutfits = "", // TODO: Implement JSON serialization
        confidence = confidence,
        timestamp = timestamp
    )

    private fun ScanHistoryEntity.toDomain() = ScanResult(
        id = id,
        imageUri = imageUri,
        detectedItems = emptyList(), // TODO: Implement JSON deserialization
        suggestedOutfits = emptyList(), // TODO: Implement JSON deserialization
        confidence = confidence,
        timestamp = timestamp
    )
}
