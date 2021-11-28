package com.iftm.mcedu.professor

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("professores")
class ProfessorController(
    private val professorService: ProfessorService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvaProfessor(@RequestBody @Valid professor: ProfessorRequest): ProfessorResponse {
        professorService.salvarProfessor(professor.toProfessorModel())
        return professor.toProfessorResponse()
    }
}