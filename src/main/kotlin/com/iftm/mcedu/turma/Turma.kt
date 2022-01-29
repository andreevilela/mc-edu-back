package com.iftm.mcedu.turma

import com.iftm.mcedu.aluno.Aluno
import com.iftm.mcedu.professor.Professor
import com.iftm.mcedu.usuario.Usuario
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
    val professores: List<Usuario>,
    @ManyToMany
    val alunos: List<Usuario>?
) {

    private constructor(): this(null, "", "", listOf(), listOf())
}