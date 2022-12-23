package com.example.kotlinjpatutorial.domain

import com.example.kotlinjpatutorial.repository.v2.AccountEntityDaoV2
import com.example.kotlinjpatutorial.testutil.testRequest1
import com.example.kotlinjpatutorial.testutil.testRequest2
import com.example.kotlinjpatutorial.testutil.testRequest3
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@SpringBootTest
class AccountServiceV2Test(
    private val accountServiceV2: AccountServiceV2,
    private val accountEntityDaoV2: AccountEntityDaoV2,
) : FunSpec({
    test("v2") {
        accountServiceV2.deposit(testRequest1)
        accountServiceV2.deposit(testRequest2)
        accountServiceV2.deposit(testRequest3)

        println("### accountEntityDaoV2.findAll()")
        accountEntityDaoV2.findAll().also {
            it[0].amount shouldBe testRequest1.totalAmount()
            it[0].id shouldBe it[0].histories[0].accountId
            it[0].histories[0].amountType shouldBe testRequest1.amounts[0].first
            it[0].histories[0].amount shouldBe testRequest1.amounts[0].second
        }
    }
})
