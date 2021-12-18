package com.finxp.account.domain.model

data class Token(
    val tokenType: String,
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Int
)
