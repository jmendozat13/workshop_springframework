package com.afoxplus.myapirest.web

import com.afoxplus.myapirest.business.IPersonaBusiness
import com.afoxplus.myapirest.exception.BusinessException
import com.afoxplus.myapirest.exception.NotFoundException
import com.afoxplus.myapirest.model.Persona
import com.afoxplus.myapirest.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping(Constants.URL_BASE_PERSONAS)
class PersonaRestController {
    @Autowired
    val personaBusiness: IPersonaBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Persona>> {
        return try {
            ResponseEntity(personaBusiness!!.list(), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idPersona: Long): ResponseEntity<Persona> {
        return try {
            ResponseEntity(personaBusiness!!.load(idPersona), HttpStatus.OK)
        } catch (ex: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (ex: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody persona: Persona): ResponseEntity<Any> {
        return try {
            personaBusiness!!.save(persona)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constants.URL_BASE_PERSONAS + "/" + persona.id)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        } catch (ex: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody persona: Persona): ResponseEntity<Any> {
        return try {
            personaBusiness!!.save(persona)
            ResponseEntity(HttpStatus.OK)
        } catch (ex: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idPersona: Long): ResponseEntity<Any> {
        return try {
            personaBusiness!!.remove(idPersona)
            ResponseEntity(HttpStatus.OK)
        } catch (ex: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (ex: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}