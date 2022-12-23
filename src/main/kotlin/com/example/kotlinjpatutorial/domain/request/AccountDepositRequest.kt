package com.example.kotlinjpatutorial.domain.request

import com.example.kotlinjpatutorial.common.type.AmountType
import com.example.kotlinjpatutorial.common.type.EventType

data class AccountDepositRequest(
    val eventType: EventType,
    val amounts: List<Pair<AmountType, Long>>
){
    fun totalAmount() : Long = amounts.sumOf { it.second }
}
