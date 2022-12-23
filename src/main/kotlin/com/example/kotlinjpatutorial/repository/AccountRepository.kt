package com.example.kotlinjpatutorial.repository

import com.example.kotlinjpatutorial.domain.request.AccountDepositRequest

interface AccountRepository {
    fun deposit(request: AccountDepositRequest)
}
