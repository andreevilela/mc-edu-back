package com.iftm.mcedu.professor

import org.springframework.data.jpa.repository.JpaRepository

@Deprecated("Testando entidade Usuario")
interface ProfessorRepository: JpaRepository<Professor, Long> {
}