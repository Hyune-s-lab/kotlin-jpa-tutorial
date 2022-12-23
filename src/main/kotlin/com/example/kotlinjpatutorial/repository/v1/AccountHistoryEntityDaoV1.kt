package com.example.kotlinjpatutorial.repository.v1

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AccountHistoryEntityDaoV1 : JpaRepository<AccountHistoryEntityV1, UUID>
