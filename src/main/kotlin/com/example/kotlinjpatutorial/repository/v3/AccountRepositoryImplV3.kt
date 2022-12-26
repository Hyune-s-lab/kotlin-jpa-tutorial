package com.example.kotlinjpatutorial.repository.v3

import com.example.kotlinjpatutorial.common.type.EventType
import com.example.kotlinjpatutorial.domain.request.AccountDepositRequest
import com.example.kotlinjpatutorial.repository.AccountRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class AccountRepositoryImplV3(
    private val accountEntityDaoV3: AccountEntityDaoV3,
) : AccountRepository {
    override fun deposit(request: AccountDepositRequest) {
        log.info("### ${this.javaClass.simpleName}")

        request.amounts.map {
            AccountHistoryEntityV3(it.first, it.second)
        }.let {
            AccountEntityV3(
                eventType = EventType.DEPOSIT,
                amount = request.totalAmount(),
                histories = it
            )
        }.let {
            accountEntityDaoV3.save(it)
        }
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}
