package com.iftm.mcedu.aluno

import javax.validation.constraints.NotEmpty

data class AlunoRequest(

    @field:NotEmpty
    val nome: String,
    @field:NotEmpty
    val email: String,
    @field:NotEmpty
    val foto: String
) {
    fun toAlunoModel(): Aluno {
        return Aluno(nome = this.nome, email = this.email, foto =  this.foto, id = null)
    }

    fun toAlunoResponse(): AlunoResponse {
        return AlunoResponse(nome = this.nome, email = this.email, foto =  this.foto)
    }
}