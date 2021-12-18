package com.finxp.account.network.model

import com.google.gson.annotations.SerializedName

data class AccountDto(
    @SerializedName("status")
    var status: String,
    @SerializedName("code")
    var code: Int,
    @SerializedName("data")
    var balance: Balance
)

data class Balance(
    @SerializedName("balance")
    var amount: Double,
    @SerializedName("currency")
    var currency: String
)
