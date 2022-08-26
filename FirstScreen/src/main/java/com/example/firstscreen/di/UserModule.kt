package com.example.firstscreen.di

import com.example.firstscreen.domain.remote.Repository
import com.example.firstscreen.data.repository.RepositoryImpl
import com.example.firstscreen.domain.remote.ServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [Network::class])
@InstallIn(SingletonComponent::class)
class UserModule {

    @Singleton
    @Provides
    fun provideUserApi(retrofit: Retrofit):ServiceApi{
        return retrofit.create(ServiceApi::class.java)
    }

    @Singleton
    @Provides
    fun provideUserRepository(serviceApi: ServiceApi):Repository{
        return RepositoryImpl(serviceApi)
    }
}
