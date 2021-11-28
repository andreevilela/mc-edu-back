package com.iftm.mcedu.professor

import org.springframework.stereotype.Service

@Service
class ProfessorService(
    private val professorRepository: ProfessorRepository
) {

    fun salvarProfessor(professor: Professor) {
        professorRepository.save(professor)
    }

    fun buscaProfessor(id: Long): Professor {
        return professorRepository.getById(id)
    }
}