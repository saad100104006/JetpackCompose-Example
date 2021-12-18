package com.finxp.account.di

import com.finxp.account.network.FinXpService
import com.finxp.account.network.util.AccountDtoMapper
import com.finxp.account.network.util.TokenDtoMapper
import com.finxp.account.repository.FinXpRepository
import com.finxp.account.repository.FinXpRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideFinXPRepository(
            finXpService: FinXpService,
            accountMapper: AccountDtoMapper,
            tokenMapper: TokenDtoMapper
    ): FinXpRepository{
        return FinXpRepositoryImpl(
            finXpService = finXpService,
            accountMapper = accountMapper,
            tokenMapper = tokenMapper
        )
    }

}

