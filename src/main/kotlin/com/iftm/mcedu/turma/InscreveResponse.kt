package com.iftm.mcedu.turma

import com.iftm.mcedu.usuario.Usuario

data class InscreveResponse(

    val codigo: String,
    val turma: String,
    val alunos: List<Usuario>
) {

}
