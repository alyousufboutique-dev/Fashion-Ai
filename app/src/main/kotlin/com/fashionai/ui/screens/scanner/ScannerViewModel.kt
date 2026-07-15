package com.fashionai.ui.screens.scanner

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fashionai.domain.model.ScanResult
import com.fashionai.domain.usecase.SaveScanResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScannerViewModel @Inject constructor(
    private val saveScanResultUseCase: SaveScanResultUseCase
) : ViewModel() {

    val isScanning = mutableStateOf(false)
    val scanResult = mutableStateOf<ScanResult?>(null)
    val errorMessage = mutableStateOf<String?>(null)

    fun performScan(imageUri: String) {
        viewModelScope.launch {
            try {
                isScanning.value = true
                errorMessage.value = null
                // TODO: Implement actual ML scanning logic
                val result = ScanResult(
                    imageUri = imageUri,
                    confidence = 0.85f
                )
                saveScanResultUseCase(result)
                scanResult.value = result
            } catch (e: Exception) {
                errorMessage.value = e.message
            } finally {
                isScanning.value = false
            }
        }
    }
}
