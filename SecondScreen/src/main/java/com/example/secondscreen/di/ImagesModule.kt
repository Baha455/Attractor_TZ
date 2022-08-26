package com.example.secondscreen.di

import android.content.Context
import com.example.secondscreen.data.repository.ImagesRepositoryImpl
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
class ImagesModule {

    @Singleton
    @Provides
    fun provideImagesRepository(@ApplicationContext context: Context): ImagesRepositoryImpl {
        return ImagesRepositoryImpl(context)
    }
}