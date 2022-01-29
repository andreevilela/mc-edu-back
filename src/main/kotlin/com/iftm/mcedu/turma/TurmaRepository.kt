package com.iftm.mcedu.turma

import org.springframework.data.jpa.repository.JpaRepository

interface TurmaRepository: JpaRepository<Turma, Long> {

    fun existsByCodigo(codigo: String): Boolean

    fun getTurmaByCodigo(codigo: String): Turma

    fun getTurmaByAlunosId(id: String): List<Turma>

    fun getTurmaByProfessoresId(id: String): List<Turma>

}