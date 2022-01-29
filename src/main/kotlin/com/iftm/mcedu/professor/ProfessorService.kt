package com.iftm.mcedu.professor

import org.springframework.stereotype.Service

@Deprecated("Testando entidade Usuario")
@Service
class ProfessorService(
    private val professorRepository: ProfessorRepository
) {

    fun salvarProfessor(professor: Professor) {
        professorRepository.save(professor)
    }

    fun buscaProfessorPeloId(id: Long): Professor {
        return professorRepository.getById(id)
    }
}