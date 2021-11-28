package com.iftm.mcedu.turma

import com.iftm.mcedu.aluno.Aluno
import com.iftm.mcedu.aluno.AlunoService
import com.iftm.mcedu.professor.Professor
import com.iftm.mcedu.professor.ProfessorService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid
import kotlin.collections.ArrayList

@RestController
@RequestMapping("turmas")
class TurmaController(
    private val turmaService: TurmaService,
    private val professorService: ProfessorService,
    private val alunoService: AlunoService
) {

    @PostMapping
    fun salvarTurma(@RequestBody @Valid turma: TurmaRequest): TurmaResponse {
        val codigo = turmaService.geraCodigoUnico()
        var professores: MutableList<Professor> = ArrayList<Professor>()
        turma.professores.forEach{
            professores.add(professorService.buscaProfessor(it))
        }
        turmaService.salvarTurma(turma.toTurmaModel(codigo, professores))
        return turma.toTurmaResponse(codigo, professores)
    }

    @PostMapping("inscricao")
    fun inscreveAluno(@RequestBody @Valid inscritos: InscreveRequest): InscreveResponse {
        val turma = turmaService.buscaTurmaPeloCodigo(inscritos.codigo)
        var alunos: MutableList<Aluno> = ArrayList<Aluno>()
        inscritos.alunos.forEach{
            alunos.add(alunoService.buscaAluno(it))
        }
        turmaService.salvarTurma(inscritos.toTurmaModel(turma, alunos))
        return inscritos.toTurmaResponse(turma, alunos)
    }
}