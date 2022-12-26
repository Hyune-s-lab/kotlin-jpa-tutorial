package com.example.kotlinjpatutorial.repository.v3

import com.example.kotlinjpatutorial.common.BaseEntity
import com.example.kotlinjpatutorial.common.type.AmountType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table

@Table(name = "account_history_v3")
@Entity
class AccountHistoryEntityV3(
    @Enumerated(EnumType.STRING)
    val amountType: AmountType,
    val amount: Long
) : BaseEntity() {
    val accountId: Long? = null
}
