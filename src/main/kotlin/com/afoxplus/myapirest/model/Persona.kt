package com.afoxplus.myapirest.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "persona")
data class Persona(val dni: Long = 0, val nombre: String = "", val apellido: String = "", val fechaNac: Date? = null) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

}