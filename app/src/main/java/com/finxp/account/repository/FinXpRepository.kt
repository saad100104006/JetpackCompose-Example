package com.finxp.account.repository

import com.finxp.account.domain.model.Account
import com.finxp.account.domain.model.Token

interface FinXpRepository {

    suspend fun getToken(email: String, password: String): Token

    suspend fun getBalance(token: String): Account

}