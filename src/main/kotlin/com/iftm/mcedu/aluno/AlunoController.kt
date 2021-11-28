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
    fun salvaAluno(@RequestBody @Valid aluno: AlunoRequest): AlunoResponse {
        alunoService.salvarAluno(aluno.toAlunoModel())
        return aluno.toAlunoResponse()
    }

}