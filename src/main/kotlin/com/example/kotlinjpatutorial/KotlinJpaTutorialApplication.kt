package com.example.kotlinjpatutorial

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class KotlinJpaTutorialApplication

fun main(args: Array<String>) {
    runApplication<KotlinJpaTutorialApplication>(*args)
}
