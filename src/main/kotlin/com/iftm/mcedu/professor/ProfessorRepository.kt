package com.iftm.mcedu.professor

import org.springframework.data.jpa.repository.JpaRepository

interface ProfessorRepository: JpaRepository<Professor, Long> {
}