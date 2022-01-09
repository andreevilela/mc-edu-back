package com.iftm.mcedu.turma

import org.springframework.stereotype.Service
import java.util.*

@Service
class TurmaService(
    private val turmaRepository: TurmaRepository
) {

    fun salvarTurma(turma: Turma) {
        turmaRepository.save(turma)
    }

    fun buscaTurmaPeloCodigo(codigo: String): Turma {
        return turmaRepository.getTurmaByCodigo(codigo)
    }

    fun buscaTurmaPeloId(id: Long): Turma {
        return turmaRepository.getById(id)
    }

    fun geraUuid(): String {
        return UUID.randomUUID().toString()
    }

    fun geraCodigo(uuid: String): String {
        val array = uuid.split("-")
        return array[0]
    }

    fun geraCodigoUnico(): String {
        val uuid = geraUuid()
        val codigo = geraCodigo(uuid)
        val existeCodigo = turmaRepository.existsByCodigo(codigo)
        if (existeCodigo) {
            geraCodigoUnico()
        }
        return codigo
    }

    fun buscaTurmasDoAluno(id: Long): List<Turma> {
        return turmaRepository.getTurmaByAlunosId(id)
    }

    fun buscaTurmasDoProfessor(id: Long): List<Turma> {
        return turmaRepository.getTurmaByProfessoresId(id)
    }

}