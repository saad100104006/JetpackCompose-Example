package com.finxp.account.domain.util

interface DomainMapper <T, DomainModel>{

    fun mapToDomainModel(model: T): DomainModel

}