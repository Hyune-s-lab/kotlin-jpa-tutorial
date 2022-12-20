package com.example.kotlinjpatutorial

import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AccountEntityTest(
    val accountEntityRepository: AccountEntityRepository,
    val accountHistoryEntityRepository: AccountHistoryEntityRepository,
) : BehaviorSpec({

    given("test") {
        accountEntityRepository.save(AccountEntity(
            histories = mutableListOf(AccountHistoryEntity())
        ))

        println("### ${accountEntityRepository.findAll()[0].histories[0].id}")
    }
})
