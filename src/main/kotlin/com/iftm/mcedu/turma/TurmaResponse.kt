package com.iftm.mcedu.turma

import com.iftm.mcedu.aluno.Aluno
import com.iftm.mcedu.professor.Professor
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotEmpty

data class TurmaResponse(

    val nome: String,
    val codigo: String,
    val professores: List<Professor>
) {
}