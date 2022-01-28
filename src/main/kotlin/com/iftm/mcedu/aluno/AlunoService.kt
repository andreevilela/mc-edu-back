package com.iftm.mcedu.aluno

import com.iftm.mcedu.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class AlunoService(
    private val alunoRepository: AlunoRepository
) {

    fun salvarAluno(aluno: Aluno) {
        alunoRepository.save(aluno)
    }

    fun buscaAlunoPeloId(id: Long): Aluno {
        return alunoRepository.getById(id)
    }

    fun buscaAlunoPeloEmail(email: String): Aluno {
        return alunoRepository.getByEmail(email) ?: throw NotFoundException("", "")
    }
}