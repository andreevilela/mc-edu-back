package com.iftm.mcedu.turma

import com.iftm.mcedu.aluno.Aluno

data class InscreveResponse(

    val codigo: String,
    val turma: String,
    val alunos: List<Aluno>
) {

}
