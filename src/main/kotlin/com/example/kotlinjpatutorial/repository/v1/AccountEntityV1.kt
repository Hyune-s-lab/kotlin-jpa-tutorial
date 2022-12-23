package com.example.kotlinjpatutorial.repository.v1

import com.example.kotlinjpatutorial.common.BaseEntity
import com.example.kotlinjpatutorial.common.type.EventType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table


@Table(name = "account_v1")
@Entity
class AccountEntityV1(
    @Enumerated(EnumType.STRING)
    val eventType: EventType,
    val amount: Long
) : BaseEntity()
