package com.example.kotlinjpatutorial.repository.v3

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface AccountEntityDaoV3 : JpaRepository<AccountEntityV3, UUID> {
    @Query("SELECT distinct t FROM AccountEntityV3 t join fetch t.histories")
    fun findAllUsingJoin(): MutableList<AccountEntityV3>
}
