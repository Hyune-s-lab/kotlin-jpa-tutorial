package com.example.kotlinjpatutorial.testutil

import com.example.kotlinjpatutorial.common.type.AmountType
import com.example.kotlinjpatutorial.domain.request.AccountDepositRequest
import kotlin.random.Random

val testRequests = (1..5).map {
    listOf(
        AmountType.CASH to cashAmount(),
        AmountType.CARD to cardAmount(),
        AmountType.GIFT to giftAmount()
    )
}.map {
    AccountDepositRequest(amounts = it)
}

private fun cashAmount() = 10000L + Random.nextLong(0, 100)
private fun cardAmount() = 30000L + Random.nextLong(0, 100)
private fun giftAmount() = 50000L + Random.nextLong(0, 100)
