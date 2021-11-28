package com.iftm.mcedu.turma

import com.iftm.mcedu.aluno.Aluno
import javax.validation.constraints.NotEmpty

data class InscreveRequest(

    @field:NotEmpty
    val codigo: String,
    @field:NotEmpty
    val alunos: List<Long>
) {

    fun toTurmaModel(turma: Turma, alunos: List<Aluno>): Turma {
        return Turma(id = turma.id, nome = turma.nome, codigo = turma.codigo, professores = turma.professores, alunos = alunos)
    }

    fun toTurmaResponse(turma: Turma, alunos: List<Aluno>): InscreveResponse {
        return InscreveResponse(codigo = turma.codigo, turma = turma.nome, alunos = alunos)
    }
}