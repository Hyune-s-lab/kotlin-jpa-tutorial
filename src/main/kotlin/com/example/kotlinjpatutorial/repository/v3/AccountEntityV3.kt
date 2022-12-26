package com.example.kotlinjpatutorial.repository.v3

import com.example.kotlinjpatutorial.common.BaseEntity
import com.example.kotlinjpatutorial.common.type.EventType
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table


@Table(name = "account_v3")
@Entity
class AccountEntityV3(
    @Enumerated(EnumType.STRING)
    val eventType: EventType,
    val amount: Long,

    @OneToMany(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "accountId")
    val histories: List<AccountHistoryEntityV3> = listOf(),
) : BaseEntity()
