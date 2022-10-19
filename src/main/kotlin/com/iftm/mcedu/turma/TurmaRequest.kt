package com.iftm.mcedu.turma

import com.iftm.mcedu.usuario.Usuario
import javax.validation.constraints.NotEmpty

data class TurmaRequest(

    @field:NotEmpty
    val nome: String,
    @field:NotEmpty
    val professores: List<String>,
    val status: Boolean = true
) {
    fun toTurmaModel(codigo: String, professores: List<Usuario>): Turma {
        return Turma(id = null, nome = this.nome, codigo = codigo, professores = professores, alunos = null)
    }

    fun toTurmaModel(id: Long, codigo: String, professores: List<Usuario>): Turma {
        return Turma(id = id, nome = this.nome, codigo = codigo, professores = professores, alunos = null)
    }

    fun toTurmaResponse(codigo: String, professores: List<Usuario>): TurmaResponse {
        return TurmaResponse(nome = this.nome, codigo = codigo, professores = professores, status = this.status)
    }
}