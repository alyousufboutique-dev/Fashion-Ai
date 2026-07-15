package com.fashionai.di

import android.content.Context
import com.fashionai.camera.CameraManager
import com.fashionai.ml.ClothingDetectionService
import com.fashionai.ml.ImageProcessor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MLModule {
    @Singleton
    @Provides
    fun provideImageProcessor(): ImageProcessor = ImageProcessor()

    @Singleton
    @Provides
    fun provideClothingDetectionService(
        @ApplicationContext context: Context,
        imageProcessor: ImageProcessor
    ): ClothingDetectionService = ClothingDetectionService(context, imageProcessor)

    @Singleton
    @Provides
    fun provideCameraManager(
        @ApplicationContext context: Context
    ): CameraManager = CameraManager(context)
}
