package com.iftm.mcedu.aluno

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

data class AlunoResponse(

    val nome: String,
    val email: String,
    val foto: String
) {
}