package com.afoxplus.myapirest.business

import com.afoxplus.myapirest.dao.PersonaRepository
import com.afoxplus.myapirest.exception.BusinessException
import com.afoxplus.myapirest.exception.NotFoundException
import com.afoxplus.myapirest.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*

@Service
class PersonaBusiness : IPersonaBusiness {

    //ijection dependcy dentro del business
    @Autowired
    val personaRepository: PersonaRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Persona> {
        try {
            return personaRepository!!.findAll()
        } catch (ex: Exception) {
            throw BusinessException(ex.message)
        }
    }


    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idPersona: Long): Persona {
        val op: Optional<Persona>
        try {
            op = personaRepository!!.findById(idPersona)
        } catch (ex: Exception) {
            throw BusinessException(ex.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontro la persona con id $idPersona")
        }
        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(persona: Persona): Persona {
        try {
            return personaRepository!!.save(persona)
        } catch (ex: Exception) {
            throw BusinessException(ex.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun remove(idPersona: Long) {
        val op: Optional<Persona>
        try {
            op = personaRepository!!.findById(idPersona)
        } catch (ex: Exception) {
            throw BusinessException(ex.message)
        }
        if (op.isPresent) {
            try {
                personaRepository!!.delete(op.get())
            } catch (ex: Exception) {
                throw BusinessException(ex.message)
            }
        } else {
            throw NotFoundException("No se encontro la persona con id $idPersona")
        }
    }
}