package com.finxp.account.network.util

import com.finxp.account.domain.model.Account
import com.finxp.account.domain.util.DomainMapper
import com.finxp.account.network.model.AccountDto

class AccountDtoMapper : DomainMapper<AccountDto, Account> {
    override fun mapToDomainModel(model: AccountDto): Account {
        return Account(
            balance = model.balance.amount,
            currency = model.balance.currency
        )
    }
}