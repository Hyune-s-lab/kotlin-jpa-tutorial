package com.example.kotlinjpatutorial

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class AccountEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.EAGER)
    val histories: MutableList<AccountHistoryEntity> = mutableListOf(),
)
