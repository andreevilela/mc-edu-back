package com.iftm.mcedu.turma

import com.iftm.mcedu.usuario.Usuario
import com.iftm.mcedu.usuario.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("turmas")
class TurmaController(
    private val turmaService: TurmaService,
    private val usuarioService: UsuarioService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvaTurma(@RequestBody @Valid turma: TurmaRequest): TurmaResponse {
        val codigo = turmaService.geraCodigoUnico()
        var professores: MutableList<Usuario> = ArrayList<Usuario>()
        turma.professores.forEach{
            professores.add(usuarioService.buscaUsuarioPeloId(it))
        }
        turmaService.salvaTurma(turma.toTurmaModel(codigo, professores))
        return turma.toTurmaResponse(codigo, professores)
    }

    @PostMapping("inscricao")
    @ResponseStatus(HttpStatus.CREATED)
    fun inscreveAluno(@RequestBody @Valid inscritos: InscreveRequest): InscreveResponse {
        val turma = turmaService.buscaTurmaPeloCodigo(inscritos.codigo)
        var alunos: MutableList<Usuario> = ArrayList<Usuario>()
        inscritos.alunos.forEach{
            alunos.add(usuarioService.buscaUsuarioPeloId(it))
        }
        turmaService.salvaTurma(inscritos.toTurmaModel(turma, alunos))
        return inscritos.toTurmaResponse(turma, alunos)
    }

    @GetMapping("usuario/{id}")
    fun buscaTurmasDoUsuario(@PathVariable id: String): List<Turma> {
        return turmaService.buscaTurmasDoUsuario(id)
    }

    @GetMapping("professor/{id}")
    fun buscaTurmasDoProfessor(@PathVariable id: String): List<Turma> {
        return turmaService.buscaTurmasDoProfessor(id)
    }
}