package com.iftm.mcedu.turma

import com.iftm.mcedu.aluno.Aluno
import com.iftm.mcedu.aluno.AlunoService
import com.iftm.mcedu.professor.Professor
import com.iftm.mcedu.professor.ProfessorService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
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
    @ResponseStatus(HttpStatus.CREATED)
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
    @ResponseStatus(HttpStatus.CREATED)
    fun inscreveAluno(@RequestBody @Valid inscritos: InscreveRequest): InscreveResponse {
        val turma = turmaService.buscaTurmaPeloCodigo(inscritos.codigo)
        var alunos: MutableList<Aluno> = ArrayList<Aluno>()
        inscritos.alunos.forEach{
            alunos.add(alunoService.buscaAlunoPeloId(it))
        }
        turmaService.salvarTurma(inscritos.toTurmaModel(turma, alunos))
        return inscritos.toTurmaResponse(turma, alunos)
    }

    @GetMapping("aluno/{id}")
    fun buscaTurmasDoAluno(@PathVariable id: Long): List<Turma> {
        return turmaService.buscaTurmasDoAluno(id)
    }

    @GetMapping("professor/{id}")
    fun buscaTurmasDoProfessor(@PathVariable id: Long): List<Turma> {
        return turmaService.buscaTurmasDoProfessor(id)
    }
}