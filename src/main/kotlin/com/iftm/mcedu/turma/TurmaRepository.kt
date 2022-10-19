package com.iftm.mcedu.turma

import org.springframework.data.jpa.repository.JpaRepository

interface TurmaRepository: JpaRepository<Turma, Long> {

    fun existsByCodigo(codigo: String): Boolean

    fun getTurmaByCodigo(codigo: String): Turma

    fun getTurmaByAlunosIdAndStatusOrderByIdDesc(id: String, status: Boolean): List<Turma>

    fun getTurmaByProfessoresIdAndStatusOrderByIdDesc(id: String, status: Boolean): List<Turma>

}