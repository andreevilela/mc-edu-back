package com.iftm.mcedu.professor

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class ProfessorResponse(

    val nome: String,
    val email: String,
    val foto: String
) {
}