package com.iftm.mcedu.aluno

import org.springframework.stereotype.Service

@Service
class AlunoService(
    private val alunoRepository: AlunoRepository
) {
    fun salvarAluno(aluno: Aluno) {
        alunoRepository.save(aluno)
    }
}