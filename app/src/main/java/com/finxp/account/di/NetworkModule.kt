package com.finxp.account.di

import com.finxp.account.BuildConfig
import com.finxp.account.network.FinXpService
import com.finxp.account.network.util.AccountDtoMapper
import com.finxp.account.network.util.TokenDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideAccountMapper(): AccountDtoMapper {
        return AccountDtoMapper()
    }

    @Singleton
    @Provides
    fun provideTokenMapper(): TokenDtoMapper {
        return TokenDtoMapper()
    }

    @Singleton
    @Provides
    fun provideFinXpService(): FinXpService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL +"api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(FinXpService::class.java)
    }
}