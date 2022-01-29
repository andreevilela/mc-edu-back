package com.iftm.mcedu.professor

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Deprecated("Testando entidade Usuario")
@Entity
class Professor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val nome: String,
    val email: String,
    val foto: String
) {
    private constructor(): this(null, "", "", "")
}