package com.finxp.account.network.util

import com.finxp.account.domain.model.Token
import com.finxp.account.domain.util.DomainMapper
import com.finxp.account.network.model.TokenDto

class TokenDtoMapper : DomainMapper<TokenDto, Token>{
    override fun mapToDomainModel(model: TokenDto): Token {
        return Token(
            tokenType = model.tokenType,
            accessToken = model.accessToken,
            expiresIn = model.expiresIn,
            refreshToken = model.refreshToken
        )
    }

}