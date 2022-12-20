package com.example.kotlinjpatutorial

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountHistoryEntityRepository : JpaRepository<AccountEntity, UUID>
