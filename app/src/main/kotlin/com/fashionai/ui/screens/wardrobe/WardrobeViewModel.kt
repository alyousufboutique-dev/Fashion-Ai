package com.fashionai.ui.screens.wardrobe

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fashionai.domain.model.WardrobeItem
import com.fashionai.domain.usecase.GetWardrobeItemsUseCase
import com.fashionai.domain.usecase.DeleteWardrobeItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WardrobeViewModel @Inject constructor(
    getWardrobeItemsUseCase: GetWardrobeItemsUseCase,
    private val deleteWardrobeItemUseCase: DeleteWardrobeItemUseCase
) : ViewModel() {

    val wardrobeItems = getWardrobeItemsUseCase()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val isLoading = mutableStateOf(false)
    val errorMessage = mutableStateOf<String?>(null)

    fun deleteItem(item: WardrobeItem) {
        viewModelScope.launch {
            try {
                deleteWardrobeItemUseCase(item)
            } catch (e: Exception) {
                errorMessage.value = e.message
            }
        }
    }
}
