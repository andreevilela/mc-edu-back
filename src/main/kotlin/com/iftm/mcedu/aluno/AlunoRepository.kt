package com.iftm.mcedu.aluno

import org.springframework.data.jpa.repository.JpaRepository

@Deprecated("Testando entidade Usuario")
interface AlunoRepository: JpaRepository<Aluno, Long> {

    fun getByEmail(codigo: String): Aluno?

}