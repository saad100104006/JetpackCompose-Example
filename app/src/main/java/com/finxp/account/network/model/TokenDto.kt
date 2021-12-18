package com.finxp.account.network.model

import com.google.gson.annotations.SerializedName

data class TokenDto(
    @SerializedName("token_type")
    var tokenType: String,

    @SerializedName("access_token")
    var accessToken: String,

    @SerializedName("expires_in")
    var expiresIn: Int,

    @SerializedName("refresh_token")
    var refreshToken: String
)
