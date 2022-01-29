package com.iftm.mcedu.usuario

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Usuario(

    @Id
    val id: String,
    val nome: String,
    val email: String,
    val foto: String,

) {
    private constructor(): this("", "", "", "")
}