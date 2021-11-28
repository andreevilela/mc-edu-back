package com.iftm.mcedu.aluno

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

class AlunoResponse(

    @NotBlank
    val nome: String,
    @NotBlank
    val email: String,
    @NotBlank
    val foto: String
) {
}