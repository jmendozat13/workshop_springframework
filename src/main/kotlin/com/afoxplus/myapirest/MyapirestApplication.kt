package com.afoxplus.myapirest

import com.afoxplus.myapirest.dao.PersonaRepository
import com.afoxplus.myapirest.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootApplication
class MyapirestApplication: CommandLineRunner {
	@Autowired
	val personaRepository: PersonaRepository? = null

	override fun run(vararg args: String?) {
		val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val persona1 = Persona(48512530, "Valentin", "Mendoza", LocalDate.parse("25-12-1994", formatter))
		personaRepository!!.save(persona1)
	}

}

fun main(args: Array<String>) {
	runApplication<MyapirestApplication>(*args)
}
