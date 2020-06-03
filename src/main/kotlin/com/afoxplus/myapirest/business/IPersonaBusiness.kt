package com.afoxplus.myapirest.business

import com.afoxplus.myapirest.model.Persona

interface IPersonaBusiness {
    fun list(): List<Persona>
    fun load(idPersona: Long): Persona
    fun save(persona: Persona): Persona
    fun remove(idPersona: Long)

}