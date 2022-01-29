package com.iftm.mcedu.aluno

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Deprecated("Testando entidade Usuario")
@Entity
class Aluno(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val nome: String,
    val email: String,
    val foto: String
) {
    private constructor(): this(null, "", "", "")
}