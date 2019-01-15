package org.dnltsk.bowling

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class BowlingApplication

fun main(args: Array<String>) {
	SpringApplication.run(BowlingApplication::class.java, *args)
}

