package com.fashionai.di

import android.content.Context
import androidx.room.Room
import com.fashionai.data.local.database.FashionAIDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideFashionAIDatabase(
        @ApplicationContext context: Context
    ): FashionAIDatabase {
        return Room.databaseBuilder(
            context,
            FashionAIDatabase::class.java,
            "fashion_ai_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}
