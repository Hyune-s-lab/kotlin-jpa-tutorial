package com.example.kotlinjpatutorial.repository.v1

import com.example.kotlinjpatutorial.common.type.EventType
import com.example.kotlinjpatutorial.domain.request.AccountDepositRequest
import com.example.kotlinjpatutorial.repository.AccountRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class AccountRepositoryImplV1(
    private val accountEntityDaoV1: AccountEntityDaoV1,
    private val accountHistoryEntityDaoV1: AccountHistoryEntityDaoV1
) : AccountRepository {
    override fun deposit(request: AccountDepositRequest) {
        log.info("### ${this.javaClass.simpleName}")

        // 1. account 를 먼저 save 하고 id 를 가져온다.
        val accountId = accountEntityDaoV1.save(
            AccountEntityV1(
                eventType = EventType.DEPOSIT,
                amount = request.totalAmount()
            )
        ).id

        // 2. 가져온 id 로 history 를 만들어 준다.
        request.amounts.map {
            AccountHistoryEntityV1(accountId!!, it.first, it.second)
        }.let {
            accountHistoryEntityDaoV1.saveAll(it)
        }
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}
