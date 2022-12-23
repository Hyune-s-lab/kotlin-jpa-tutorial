package com.example.kotlinjpatutorial.domain

import com.example.kotlinjpatutorial.testutil.testRequest1
import com.example.kotlinjpatutorial.testutil.testRequest2
import com.example.kotlinjpatutorial.testutil.testRequest3
import io.kotest.core.spec.style.FunSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@SpringBootTest
class AccountServiceV1Test(
    private val accountServiceV1: AccountServiceV1
) : FunSpec({
    test("v1") {
        accountServiceV1.deposit(testRequest1)
        accountServiceV1.deposit(testRequest2)
        accountServiceV1.deposit(testRequest3)
    }
})
