package com.example.kotlinjpatutorial.repository.v2

import com.example.kotlinjpatutorial.common.type.EventType
import com.example.kotlinjpatutorial.domain.request.AccountDepositRequest
import com.example.kotlinjpatutorial.repository.AccountRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class AccountRepositoryImplV2(
    private val accountEntityDaoV2: AccountEntityDaoV2,
) : AccountRepository {
    override fun deposit(request: AccountDepositRequest) {
        log.info("### ${this.javaClass.simpleName}")

        request.amounts.map {
            AccountHistoryEntityV2(it.first, it.second)
        }.let {
            AccountEntityV2(
                eventType = EventType.DEPOSIT,
                amount = request.totalAmount(),
                histories = it
            )
        }.let {
            accountEntityDaoV2.save(it)
        }
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}
