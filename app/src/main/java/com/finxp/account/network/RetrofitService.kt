package com.finxp.account.network


import com.finxp.account.network.model.AccountDto
import com.finxp.account.network.model.TokenDto
import retrofit2.http.*


interface FinXpService {
    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): TokenDto

    @GET("balance")
    suspend fun getBalance(
        @Header("Authorization") token: String,
    ): AccountDto
}











