package com.fashionai.domain.usecase

import com.fashionai.data.repository.OutfitRepository
import com.fashionai.domain.model.Outfit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllOutfitsUseCase @Inject constructor(
    private val outfitRepository: OutfitRepository
) {
    operator fun invoke(): Flow<List<Outfit>> = outfitRepository.getAllOutfits()
}

class GetSavedOutfitsUseCase @Inject constructor(
    private val outfitRepository: OutfitRepository
) {
    operator fun invoke(): Flow<List<Outfit>> = outfitRepository.getSavedOutfits()
}

class CreateOutfitUseCase @Inject constructor(
    private val outfitRepository: OutfitRepository
) {
    suspend operator fun invoke(outfit: Outfit): Long = outfitRepository.createOutfit(outfit)
}

class DeleteOutfitUseCase @Inject constructor(
    private val outfitRepository: OutfitRepository
) {
    suspend operator fun invoke(outfit: Outfit) = outfitRepository.deleteOutfit(outfit)
}

class SaveOutfitUseCase @Inject constructor(
    private val outfitRepository: OutfitRepository
) {
    suspend operator fun invoke(id: Long, saved: Boolean) = outfitRepository.updateSaved(id, saved)
}
