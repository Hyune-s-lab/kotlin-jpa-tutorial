package com.example.kotlinjpatutorial.repository.v2

import com.example.kotlinjpatutorial.common.BaseEntity
import com.example.kotlinjpatutorial.common.type.EventType
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table


@Table(name = "account_v2")
@Entity
class AccountEntityV2(
    @Enumerated(EnumType.STRING)
    val eventType: EventType,
    val amount: Long,

    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.EAGER)
    @JoinColumn(name = "accountId")
    val histories: List<AccountHistoryEntityV2> = listOf(),
) : BaseEntity()
