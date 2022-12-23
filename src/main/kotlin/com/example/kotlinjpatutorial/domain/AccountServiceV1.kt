package com.example.kotlinjpatutorial.domain

import com.example.kotlinjpatutorial.domain.request.AccountDepositRequest
import com.example.kotlinjpatutorial.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountServiceV1(private val accountRepository: AccountRepository) {
    @Transactional
    fun deposit(request: AccountDepositRequest) {
        accountRepository.deposit(request)
    }
}
