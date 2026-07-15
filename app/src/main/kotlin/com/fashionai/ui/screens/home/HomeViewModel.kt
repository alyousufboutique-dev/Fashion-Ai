package com.fashionai.ui.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fashionai.domain.model.Outfit
import com.fashionai.domain.model.WardrobeItem
import com.fashionai.domain.usecase.GetWardrobeItemsUseCase
import com.fashionai.domain.usecase.GetAllOutfitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getWardrobeItemsUseCase: GetWardrobeItemsUseCase,
    getAllOutfitsUseCase: GetAllOutfitsUseCase
) : ViewModel() {

    val wardrobeItems = getWardrobeItemsUseCase()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val outfits = getAllOutfitsUseCase()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val isLoading = mutableStateOf(false)
    val errorMessage = mutableStateOf<String?>(null)
}
