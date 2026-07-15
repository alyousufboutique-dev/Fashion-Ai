package com.fashionai.di

import com.fashionai.data.repository.WardrobeRepository
import com.fashionai.data.repository.OutfitRepository
import com.fashionai.data.repository.ScanRepository
import com.fashionai.data.repository.impl.WardrobeRepositoryImpl
import com.fashionai.data.repository.impl.OutfitRepositoryImpl
import com.fashionai.data.repository.impl.ScanRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindWardrobeRepository(
        impl: WardrobeRepositoryImpl
    ): WardrobeRepository

    @Singleton
    @Binds
    abstract fun bindOutfitRepository(
        impl: OutfitRepositoryImpl
    ): OutfitRepository

    @Singleton
    @Binds
    abstract fun bindScanRepository(
        impl: ScanRepositoryImpl
    ): ScanRepository
}
