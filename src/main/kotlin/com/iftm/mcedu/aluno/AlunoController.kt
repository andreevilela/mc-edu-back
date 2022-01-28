package com.iftm.mcedu.aluno

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("alunos")
class AlunoController(
    private val alunoService: AlunoService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvaAluno(@RequestBody @Valid aluno: Aluno): Aluno {
        alunoService.salvarAluno(aluno)
        return alunoService.buscaAlunoPeloEmail(aluno.email)
    }

    @GetMapping("/{id}")
    fun buscaAlunoPeloId(@PathVariable id: Long): Aluno {
        return alunoService.buscaAlunoPeloId(id)
    }

    @GetMapping("/email/{email}")
    fun buscaAlunoPeloEmail(@PathVariable email: String): Aluno {
        return alunoService.buscaAlunoPeloEmail(email)
    }
}