package com.shu.network.di

import com.shu.home.domain.HomeRepository
import com.shu.network.ServiceGameApi
import com.shu.network.repository.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun providesRepository(
        api: ServiceGameApi,
       // dao: MovieDao
    ): HomeRepository {
        return HomeRepositoryImpl(api)
    }

}