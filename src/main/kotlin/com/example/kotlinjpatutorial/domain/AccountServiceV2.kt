package com.example.kotlinjpatutorial.domain

import com.example.kotlinjpatutorial.domain.request.AccountDepositRequest
import com.example.kotlinjpatutorial.repository.AccountRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountServiceV2(@Qualifier("accountRepositoryImplV2") private val accountRepository: AccountRepository) {
    @Transactional
    fun deposit(request: AccountDepositRequest) {
        accountRepository.deposit(request)
    }
}
