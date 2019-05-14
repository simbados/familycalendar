package de.schmoll.familyserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FamilyServerApplication

fun main(args: Array<String>) {
	runApplication<FamilyServerApplication>(*args)
}
