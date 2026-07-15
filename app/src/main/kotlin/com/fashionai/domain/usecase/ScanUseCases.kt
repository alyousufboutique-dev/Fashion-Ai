package com.fashionai.domain.usecase

import com.fashionai.data.repository.ScanRepository
import com.fashionai.domain.model.ScanResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveScanResultUseCase @Inject constructor(
    private val scanRepository: ScanRepository
) {
    suspend operator fun invoke(scan: ScanResult): Long = scanRepository.saveScan(scan)
}

class GetRecentScansUseCase @Inject constructor(
    private val scanRepository: ScanRepository
) {
    operator fun invoke(limit: Int = 10): Flow<List<ScanResult>> = scanRepository.getRecentScans(limit)
}

class GetAllScansUseCase @Inject constructor(
    private val scanRepository: ScanRepository
) {
    operator fun invoke(): Flow<List<ScanResult>> = scanRepository.getAllScans()
}
