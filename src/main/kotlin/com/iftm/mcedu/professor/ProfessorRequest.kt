package com.iftm.mcedu.professor

import javax.persistence.Entity
import javax.validation.constraints.NotEmpty

data class ProfessorRequest(

    @field:NotEmpty
    val nome: String,
    @field:NotEmpty
    val email: String,
    @field:NotEmpty
    val foto: String
) {
    fun toProfessorModel(): Professor {
        return Professor(nome = this.nome, email = this.email, foto = this.foto, id = null)
    }

    fun toProfessorResponse(): ProfessorResponse {
        return ProfessorResponse(nome = this.nome, email = this.email, foto = this.foto)
    }
}