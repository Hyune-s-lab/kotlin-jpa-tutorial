package com.example.kotlinjpatutorial.repository.v2

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AccountEntityDaoV2 : JpaRepository<AccountEntityV2, UUID>
