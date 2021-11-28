package com.iftm.mcedu.turma

import com.iftm.mcedu.aluno.Aluno
import com.iftm.mcedu.professor.Professor
import java.util.*
import javax.persistence.*

@Entity
class TurmaRequest(

    @Id
    val id: String = UUID.randomUUID().toString(),
    val nome: String,
    @ManyToMany
    val professores: List<Professor>,
    @ManyToMany
    val alunos: List<Aluno>
) {
}