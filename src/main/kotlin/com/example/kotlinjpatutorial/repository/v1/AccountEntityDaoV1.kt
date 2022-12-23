package com.example.kotlinjpatutorial.repository.v1

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AccountEntityDaoV1 : JpaRepository<AccountEntityV1, UUID>
