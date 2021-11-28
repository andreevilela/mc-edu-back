package com.iftm.mcedu.turma

import com.iftm.mcedu.professor.Professor
import com.iftm.mcedu.professor.ProfessorService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("turmas")
class TurmaController(
    private val turmaService: TurmaService,
    private val professorService: ProfessorService
) {

    @PostMapping
    fun salvarTurma(@RequestBody @Valid turma: TurmaRequest): TurmaResponse {
        val codigo = turmaService.geraCodigoUnico()
        var professores: MutableList<Professor> = ArrayList<Professor>()
        turma.professores.forEach{
            professores.add(professorService.buscaProfessores(it))
        }
        turmaService.salvarTurma(turma.toTurmaModel(codigo, professores))
        return turma.toTurmaResponse(codigo, professores)
    }
}