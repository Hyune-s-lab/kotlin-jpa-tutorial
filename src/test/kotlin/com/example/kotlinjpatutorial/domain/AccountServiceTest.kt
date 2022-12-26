package com.example.kotlinjpatutorial.domain

import com.example.kotlinjpatutorial.repository.v2.AccountEntityDaoV2
import com.example.kotlinjpatutorial.repository.v3.AccountEntityDaoV3
import com.example.kotlinjpatutorial.testutil.testRequests
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@SpringBootTest
class AccountServiceTest(
    private val accountServiceV1: AccountServiceV1,

    private val accountServiceV2: AccountServiceV2,
    private val accountEntityDaoV2: AccountEntityDaoV2,

    private val accountServiceV3: AccountServiceV3,
    private val accountEntityDaoV3: AccountEntityDaoV3,
) : FunSpec({
    test("v1") {
        testRequests.forEach {
            accountServiceV1.deposit(it)
        }
    }

    test("v2") {
        testRequests.forEach {
            accountServiceV2.deposit(it)
        }

        println("### accountEntityDaoV2.findAll()")
        accountEntityDaoV2.findAll()[0].also {
            it.amount shouldBe testRequests[0].totalAmount()
            it.id shouldBe it.histories[0].accountId
            it.histories[0].amountType shouldBe testRequests[0].amounts[0].first
            it.histories[0].amount shouldBe testRequests[0].amounts[0].second
        }
    }

    test("v3") {
        testRequests.forEach {
            accountServiceV3.deposit(it)
        }

        println("### accountEntityDaoV3.findAll()")
        accountEntityDaoV3.findAllUsingJoin()[0].also {
            it.amount shouldBe testRequests[0].totalAmount()
            it.id shouldBe it.histories[0].accountId
            it.histories[0].amountType shouldBe testRequests[0].amounts[0].first
            it.histories[0].amount shouldBe testRequests[0].amounts[0].second
        }
    }
})
