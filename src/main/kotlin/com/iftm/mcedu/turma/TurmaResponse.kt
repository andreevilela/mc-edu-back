package com.iftm.mcedu.turma

import com.iftm.mcedu.aluno.Aluno
import com.iftm.mcedu.professor.Professor
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotEmpty

data class TurmaResponse(

    @field:NotEmpty
    val nome: String,
    @field:NotEmpty
    val professores: List<Professor>
) {
}