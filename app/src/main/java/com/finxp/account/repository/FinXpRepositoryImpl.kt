package com.finxp.account.repository

import com.finxp.account.domain.model.Account
import com.finxp.account.domain.model.Token
import com.finxp.account.network.FinXpService
import com.finxp.account.network.util.AccountDtoMapper
import com.finxp.account.network.util.TokenDtoMapper

class FinXpRepositoryImpl (
    private val finXpService: FinXpService,
    private val accountMapper: AccountDtoMapper,
    private val tokenMapper: TokenDtoMapper
): FinXpRepository {
    override suspend fun getToken(email: String, password: String): Token {
        return tokenMapper.mapToDomainModel(finXpService.login(email = email, password = password))
    }

    override suspend fun getBalance(token: String): Account {
        return accountMapper.mapToDomainModel(finXpService.getBalance(token = token))
    }
}