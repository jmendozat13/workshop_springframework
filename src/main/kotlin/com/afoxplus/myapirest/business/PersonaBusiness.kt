package com.afoxplus.myapirest.business

import com.afoxplus.myapirest.dao.PersonaRepository
import com.afoxplus.myapirest.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonaBusiness : IPersonaBusiness{

    //ijection dependcy dentro del business
    @Autowired
    val personaRepository: PersonaRepository? = null

    override fun list(): List<Persona> {
        TODO("Not yet implemented")
    }

    override fun load(idPersona: Long): Persona {
        TODO("Not yet implemented")
    }

    override fun save(persona: Persona): Persona {
        TODO("Not yet implemented")
    }

    override fun remove(idPersona: Long) {
        TODO("Not yet implemented")
    }
}