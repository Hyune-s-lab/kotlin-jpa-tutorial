package com.example.kotlinjpatutorial.domain.request

import com.example.kotlinjpatutorial.common.type.AmountType
import com.example.kotlinjpatutorial.common.type.EventType

data class AccountDepositRequest(
    val amounts: List<Pair<AmountType, Long>>
) {
    val eventType: EventType = EventType.DEPOSIT

    fun totalAmount(): Long = amounts.sumOf { it.second }
}
