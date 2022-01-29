package com.iftm.mcedu.turma

import com.iftm.mcedu.usuario.Usuario
import javax.validation.constraints.NotEmpty

data class InscreveRequest(

    @field:NotEmpty
    val codigo: String,
    @field:NotEmpty
    val alunos: List<String>
) {

    fun toTurmaModel(turma: Turma, alunos: List<Usuario>): Turma {
        return Turma(id = turma.id, nome = turma.nome, codigo = turma.codigo, professores = turma.professores, alunos = alunos)
    }

    fun toTurmaResponse(turma: Turma, alunos: List<Usuario>): InscreveResponse {
        return InscreveResponse(codigo = turma.codigo, turma = turma.nome, alunos = alunos)
    }
}