package com.iftm.mcedu.turma

import org.springframework.data.jpa.repository.JpaRepository

interface TurmaRepository: JpaRepository<Turma, String> {

    fun existsByCodigo(codigo: String): Boolean
}