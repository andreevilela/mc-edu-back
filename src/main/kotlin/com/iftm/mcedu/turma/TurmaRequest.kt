package com.iftm.mcedu.turma

import com.iftm.mcedu.professor.Professor
import java.util.*
import javax.validation.constraints.NotEmpty

data class TurmaRequest(

    @field:NotEmpty
    val nome: String,
    @field:NotEmpty
    val professores: List<Long>
) {
    fun toTurmaModel(codigo: String, professores: List<Professor>): Turma {
        return Turma(id = null, nome = this.nome, codigo = codigo, professores = professores, alunos = null)
    }

    fun toTurmaResponse(codigo: String, professores: List<Professor>): TurmaResponse {
        return TurmaResponse(nome = this.nome, codigo = codigo, professores = professores)
    }
}