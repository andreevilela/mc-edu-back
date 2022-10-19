package com.iftm.mcedu.turma

import com.iftm.mcedu.usuario.Usuario
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
    val alunos: List<Usuario>?,
    var status: Boolean = true
) {

    private constructor(): this(null, "", "", listOf(), listOf(), true)
}