package com.iftm.mcedu.turma

import com.iftm.mcedu.aluno.Aluno
import com.iftm.mcedu.professor.Professor
import java.util.*
import javax.persistence.*

@Entity
class Turma(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val nome: String,
    val codigo: String,
    @ManyToMany
    val professores: List<Professor>,
    @ManyToMany
    val alunos: List<Aluno>?
) {

    private constructor(): this(null, "", "", listOf(), null)
}