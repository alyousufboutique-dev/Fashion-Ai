package com.fashionai.domain.usecase

import com.fashionai.data.repository.WardrobeRepository
import com.fashionai.domain.model.WardrobeItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWardrobeItemsUseCase @Inject constructor(
    private val wardrobeRepository: WardrobeRepository
) {
    operator fun invoke(): Flow<List<WardrobeItem>> = wardrobeRepository.getAllItems()
}

class AddWardrobeItemUseCase @Inject constructor(
    private val wardrobeRepository: WardrobeRepository
) {
    suspend operator fun invoke(item: WardrobeItem): Long = wardrobeRepository.addItem(item)
}

class DeleteWardrobeItemUseCase @Inject constructor(
    private val wardrobeRepository: WardrobeRepository
) {
    suspend operator fun invoke(item: WardrobeItem) = wardrobeRepository.deleteItem(item)
}

class GetWardrobeItemByIdUseCase @Inject constructor(
    private val wardrobeRepository: WardrobeRepository
) {
    suspend operator fun invoke(id: Long): WardrobeItem? = wardrobeRepository.getItemById(id)
}
