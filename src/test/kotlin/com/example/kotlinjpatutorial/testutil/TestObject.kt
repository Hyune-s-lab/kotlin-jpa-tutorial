package com.example.kotlinjpatutorial.testutil

import com.example.kotlinjpatutorial.common.type.AmountType
import com.example.kotlinjpatutorial.common.type.EventType
import com.example.kotlinjpatutorial.domain.request.AccountDepositRequest

val testRequest1 = AccountDepositRequest(
    eventType = EventType.DEPOSIT,
    amounts = listOf(
        AmountType.CASH to 10_123L,
        AmountType.CARD to 20_456L,
        AmountType.GIFT to 30_789L
    )
)

val testRequest2 = AccountDepositRequest(
    eventType = EventType.DEPOSIT,
    amounts = listOf(
        AmountType.CASH to 30_123L,
        AmountType.CARD to 50_456L,
    )
)

val testRequest3 = AccountDepositRequest(
    eventType = EventType.DEPOSIT,
    amounts = listOf(
        AmountType.GIFT to 90_589L
    )
)
