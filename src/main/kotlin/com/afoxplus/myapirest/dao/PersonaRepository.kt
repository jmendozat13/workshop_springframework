package com.afoxplus.myapirest.dao

import com.afoxplus.myapirest.model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonaRepository : JpaRepository<Persona, Long>